package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.Category;
import com.narcissux.blog.mapper.CategoryMapper;
import com.narcissux.blog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
