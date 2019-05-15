package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.ArticleTag;
import com.narcissux.blog.mapper.ArticleTagMapper;
import com.narcissux.blog.model.entity.Tag;
import com.narcissux.blog.service.ArticleTagService;
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
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

    /**
     * 获取文章所有标签
     *
     * @param articleId
     * @return
     */
    @Override
    public List<Tag> queryArticleTags(Integer articleId) {
        return this.baseMapper.queryArticleTags(articleId);
    }
}
