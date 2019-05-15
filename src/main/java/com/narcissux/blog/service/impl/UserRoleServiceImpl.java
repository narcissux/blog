package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.UserRole;
import com.narcissux.blog.mapper.UserRoleMapper;
import com.narcissux.blog.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author xiaye
 * @since 2019-05-12
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
