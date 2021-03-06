package com.narcissux.blog;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.narcissux.blog.common.utils.Query;
import com.narcissux.blog.component.R;
import com.narcissux.blog.controller.ArticleController;
import com.narcissux.blog.mapper.ArticleMapper;
import com.narcissux.blog.mapper.TagMapper;
import com.narcissux.blog.mapper.UserMapper;
import com.narcissux.blog.model.entity.User;
import com.narcissux.blog.model.vo.ArticleVo;
import com.narcissux.blog.service.ArticleService;
import com.narcissux.blog.service.UserService;
import com.narcissux.blog.service.impl.ArticleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatis {

    @Autowired
    UserService service;

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleController articleController;

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void selectArticlePage() {
        IPage<ArticleVo> page = articleMapper.queryArticleList2(new Page<ArticleVo>());
        System.out.println(page.getRecords());
    }

    @Test
    public void selectArticlePage2() {
        Map<String, Object> map = new HashMap<>();
        map.put("page",0);
        R r = articleController.list(map);
        System.out.println(r);
    }
/**
 *
 *
    @Test
    public void selectUserByPrimaryKey() {
        User user = new User();
        user.setName("夏夜3");
        user.setAvatar("sfsfs");
        user.setCreateTime(LocalDateTime.now());
        user.setEmail("dfdf");
        user.setIsAdmin(0);
        user.setLastLoginTime(LocalDateTime.now());
        user.setNickname("xiamengmeng");
        user.setPassword("dfdf");
        user.setPhone("15296dfdfds");
        user.setStatus(2);
        user.setUpdateTime(LocalDateTime.now());

        System.out.println(service.save(user));
    }

    @Test
    public void selectByPrimaryKey2() {
        System.out.println(service.getById(1));
    }

    @Test
    public void selectArticlePage(){
        Map params = new HashMap<String,Object>();
        params.put("sidx","create_time");
        params.put("order","ascs");
        System.out.println(articleService.queryPage(params));
    }


    @Test
    public void selectArticleByWrepper(){
        Map params = new HashMap<String,Object>();
        params.put("sidx","create_time");
        params.put("order","ascs");
        System.out.println(articleService.getArticleAndAddViewNum(2L));
    }

    @Test
    public void selectArticlefrepper(){
        Map params = new HashMap<String,Object>();
        params.put("sidx","create_time");
        params.put("order","ascs");
        System.out.println(articleService.getArticleAndAddViewNum(2L));
    }
    **/
}