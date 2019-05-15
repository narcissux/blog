package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.User;
import com.narcissux.blog.mapper.UserMapper;
import com.narcissux.blog.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
