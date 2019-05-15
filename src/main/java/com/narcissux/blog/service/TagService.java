package com.narcissux.blog.service;

import com.narcissux.blog.model.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
public interface TagService extends IService<Tag> {

    public List<Tag> listTagByUid(Integer id);
}
