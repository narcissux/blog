package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.Comment;
import com.narcissux.blog.mapper.CommentMapper;
import com.narcissux.blog.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
