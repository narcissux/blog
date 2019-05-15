package com.narcissux.blog.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.narcissux.blog.common.utils.JwtUtils;
import com.narcissux.blog.common.utils.Query;
import com.narcissux.blog.component.R;
import com.narcissux.blog.model.entity.User;
import com.narcissux.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户模块")
@CrossOrigin
public class UserController {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    private final static String ACCUNT_LOCK = "3";
    private final static String ACCUNT_NEW = "3";

    @Autowired
    UserService userService;
    /**
     * 用户登录(不带验证码)
     *
     * @param json
     * @return
     * @throws IOException
     */
    @ApiOperation(value="登录用户", notes="登录")
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody JSONObject json) throws IOException {
        String username = json.getString("name");
        String password = json.getString("password");
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return R.error("参数不对");
        }

        //用户信息
        User user = userService.getOne(new QueryWrapper<User>().eq("name",username));

        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }

        //账号锁定
        if (ACCUNT_LOCK.equals(user.getStatus())) {
            return R.error("账号已被锁定,请联系管理员");
        }
        String uid = user.getId().toString();
        Map<String, Object> map = new HashMap<>();
        if (redisTemplate.hasKey(uid))
        {
            // 按照超时策略是否重新生成token
            String checkToken = JwtUtils.checkExpired((String)redisTemplate.opsForValue().get(uid));
            map.put("auth-token", checkToken);
            return R.ok(map);
        }
        //如果redis没有token,则重新生成token，并保存到数据库
        map.put("auth-token",JwtUtils.generateToken(user.getId()));
        return R.ok(map);
}

    /**
     * 账号注册
     *
     * @param json
     * @return
     * @throws IOException
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody JSONObject json) throws IOException {
        String username = json.getString("name");
        String password = json.getString("password");
        String nickname = json.getString("nickname");
        String email = json.getString("email");
        String phone = json.getString("phone");
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(nickname)) {
            return R.error("参数不对");
        }

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name",username)
                .or().eq("email",email)
                .or().eq("phone",phone);
        //用户信息
        List<User> users = userService.list(wrapper);

        //账号已存在
        if (users != null && !users.isEmpty()) {
            return R.error("该账号已存在");
        }

        User user = new User();
        user.setName(username);
        user.setIsAdmin(1);
        user.setNickname(nickname);
        user.setLastLoginTime(LocalDateTime.now());
        user.setStatus(Integer.valueOf(ACCUNT_NEW));
        String salt = RandomStringUtils.randomAlphanumeric(8);
        user.setSalt(salt);
        user.setPassword(new Sha256Hash(password, salt).toHex());
        user.setEmail(email);
        user.setPhone(phone);
        boolean insert = userService.save(user);
        if (!insert) {
            return R.error("注册账号失败了");
        }
        return R.ok("ok");
    }
}

