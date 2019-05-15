package com.narcissux.blog.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.narcissux.blog.component.R;
import com.narcissux.blog.model.entity.Category;
import com.narcissux.blog.service.CategoryService;
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
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping ("/list")
    public R list(){
        return R.ok(categoryService.list());
    }

    @GetMapping ("/{id}")
    public R getCategory(@PathVariable Integer id){
        return R.ok(categoryService.getById(id));
    }

    @PatchMapping ("")
    public R updateCategory(@RequestBody JSONObject json){
        Category category = JSON.toJavaObject(json, Category.class);
        return R.ok(categoryService.updateById(category));
    }

    @PostMapping ("")
    public R newCategory(@RequestBody JSONObject json){
        Category category = JSON.toJavaObject(json, Category.class);
        return R.ok(categoryService.save(category));
    }

    @DeleteMapping ("/{id}")
    public R deleteCategory(@PathVariable Integer id){
        return R.ok(categoryService.removeById(id));
    }
}

