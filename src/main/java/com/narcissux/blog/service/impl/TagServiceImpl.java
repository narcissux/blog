package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.Tag;
import com.narcissux.blog.mapper.TagMapper;
import com.narcissux.blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Override
    public List<Tag> listTagByUid(Integer id) {
        return getBaseMapper().listTagByUid(id);
    }
}
