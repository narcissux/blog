package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.RoleResource;
import com.narcissux.blog.mapper.RoleResourceMapper;
import com.narcissux.blog.service.RoleResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源角色关联表 服务实现类
 * </p>
 *
 * @author xiaye
 * @since 2019-05-12
 */
@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements RoleResourceService {

}
