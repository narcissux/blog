package com.narcissux.blog.mapper;

import com.narcissux.blog.model.entity.ArticleTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.narcissux.blog.model.entity.Tag;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

    /**
     * 查询某篇文章的所有tag
     * @param articleId
     * @return
     */
    public List<Tag> queryArticleTags(Integer articleId);

}
