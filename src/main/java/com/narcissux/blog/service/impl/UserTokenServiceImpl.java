package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.UserToken;
import com.narcissux.blog.mapper.UserTokenMapper;
import com.narcissux.blog.service.UserTokenService;
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
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {

}
