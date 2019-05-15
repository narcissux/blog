package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.Role;
import com.narcissux.blog.mapper.RoleMapper;
import com.narcissux.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author xiaye
 * @since 2019-05-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
