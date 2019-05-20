package com.narcissux.blog.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.narcissux.blog.model.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.narcissux.blog.model.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
@Component
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 条件查询分页列表
     * @return
     */
    public List<ArticleVo> queryArticleByWrepper(int start ,int size, @Param("ew") Wrapper<ArticleVo> wrapper);

    /**
     * 条件查询
     * @return
     */
    public List<ArticleVo> queryArticleList(@Param("ew") Wrapper<ArticleVo> wrapper);

    /**
     * 嵌套多表分页查询 / 暂时废弃，因为使用数据库连接使用多次
     * @return
     */
    public IPage<ArticleVo> queryArticleList2(Page<ArticleVo> page);
}
