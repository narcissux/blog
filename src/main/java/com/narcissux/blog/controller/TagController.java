package com.narcissux.blog.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.narcissux.blog.component.R;
import com.narcissux.blog.model.entity.Tag;
import com.narcissux.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
@RestController
@RequestMapping("/tag")
@CrossOrigin
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public R list(){
        return R.ok(tagService.list());
    }

    @GetMapping("/list/{id}")
    public R list(@PathVariable Integer id){
        return R.ok(tagService.listTagByUid(id));
    }

    @GetMapping ("/{id}")
    public R getTag(@PathVariable Integer id){
        return R.ok(tagService.getById(id));
    }

    @PatchMapping ("")
    public R updateTag(@RequestBody JSONObject json){
        Tag Tag = JSON.toJavaObject(json, Tag.class);
        return R.ok(tagService.updateById(Tag));
    }

    @PostMapping ("")
    public R newTag(@RequestBody JSONObject json){
        Tag Tag = JSON.toJavaObject(json, Tag.class);
        return R.ok(tagService.save(Tag));
    }

    @DeleteMapping ("/{id}")
    public R deleteTag(@PathVariable Integer id){
        return R.ok(tagService.removeById(id));
    }


}

