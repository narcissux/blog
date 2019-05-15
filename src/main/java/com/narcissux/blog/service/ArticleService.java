package com.narcissux.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.narcissux.blog.model.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.narcissux.blog.model.entity.User;
import com.narcissux.blog.model.vo.ArticleVo;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaye
 * @since 2019-04-30
 */
public interface ArticleService extends IService<Article> {

    /**
     * 获取文章并增加阅览次数
     * @param id
     * @return
     */
    public ArticleVo getArticleAndAddViewNum(Long id);

    /**
     * 编辑文章
     * @param user
     * @param article
     * @return
     */
    public Integer updateArticle(User user, JSONObject article);

    /**
     * 增加一篇文章
     * @param user
     * @param article
     * @return
     */
    public Integer addArticle(User user, JSONObject article);

    /**
     * 删除文章，并删除tag的关联
     * @param id
     */
    public void deleteArticle(Long id);

    /**
     * 分页查询文章
     * @param params
     * @return
     */
    List<ArticleVo> queryPage(Map<String, Object> params);
}
