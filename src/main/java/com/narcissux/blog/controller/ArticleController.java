package com.narcissux.blog.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.narcissux.blog.common.shiro.JWTFilter;
import com.narcissux.blog.common.utils.JwtUtils;
import com.narcissux.blog.component.R;
import com.narcissux.blog.model.entity.Article;
import com.narcissux.blog.model.entity.User;
import com.narcissux.blog.model.vo.ArticleVo;
import com.narcissux.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
@Api("文章|模块")
@RestController
@RequestMapping("/article")
@Slf4j
@CrossOrigin
public class ArticleController {

    @Autowired
    ArticleService articleService;
    /**
     * 列表 分页查询
     */
    @ApiOperation(value = "按wrapper查询文章",notes = "查询文章列表")
    @ApiImplicitParam(name="params",value="参数",required = false)
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        Map<String,Object> map = articleService.queryPage(params);
        R r = R.ok(JSON.parseArray(JSON.toJSONString(map.get("data"))));
        r.put("total",map.get("total"));
        return r;
    }

    /**
     * 根据单个Id查询list
     */
    @GetMapping("/{id}")
    public R getArticle(@PathVariable Long id){
        ArticleVo article = articleService.getArticleAndAddViewNum(id);
        return R.ok(JSON.parseObject(JSON.toJSONString(article)));
    }

    /**
     * 更新文章
     */
    @PatchMapping("")
    public R updateArticle(@RequestBody JSONObject json){
        // String token = (String) SecurityUtils.getSubject().getPrincipal();
        User user  = new User();
        // user.setId(JwtUtils.getJson(token).getInteger("uid"));
        user.setId(1008);  // 暂时写死
        Integer id = articleService.updateArticle(user,json);
        return R.ok(id);
    }

    /**
     * 新增文章
     */
    @PostMapping("")
    public R newArticle(@RequestBody JSONObject json){
        //String token = (String) SecurityUtils.getSubject().getPrincipal();
        User user  = new User();
        //user.setId(JwtUtils.getJson(token).getInteger("uid"));
        user.setId(json.getInteger("userId"));
        Integer id = articleService.addArticle(user,json);
        return R.ok(id);
    }

    /**
     * 删除文章
     */
    @DeleteMapping("/{id}")
    public R deleteArticle(@PathVariable Long id){
        User user = new User(); // ShiroUtils.getUserEntity();
        articleService.deleteArticle(id);
        return R.ok(id);
    }



}

