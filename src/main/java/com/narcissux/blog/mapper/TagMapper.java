package com.narcissux.blog.mapper;

import com.narcissux.blog.model.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
public interface TagMapper extends BaseMapper<Tag> {

    public List<Tag> listTagByUid(Integer uid);
}
