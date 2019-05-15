package com.narcissux.blog.service;

import com.narcissux.blog.model.entity.ArticleTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.narcissux.blog.model.entity.Tag;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
public interface ArticleTagService extends IService<ArticleTag> {

    /**
     * 查询某篇文章的所有tag
     * @param articleId
     * @return
     */
    public List<Tag> queryArticleTags(Integer articleId);

}
