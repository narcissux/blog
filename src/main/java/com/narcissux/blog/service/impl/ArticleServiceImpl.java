package com.narcissux.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.narcissux.blog.common.exception.RestException;
import com.narcissux.blog.common.utils.Query;
import com.narcissux.blog.model.entity.*;
import com.narcissux.blog.mapper.ArticleMapper;
import com.narcissux.blog.model.vo.ArticleVo;
import com.narcissux.blog.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import javax.jws.soap.SOAPBinding;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yux
 * @since 2019-04-30
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TagService tagService;

    @Autowired
    ArticleTagService articleTagService;


    /**
     * 查询文章与增加浏览数。这里待优化SQL
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ArticleVo getArticleAndAddViewNum(Long id) {
        QueryWrapper<ArticleVo> wrapper = new QueryWrapper<>();
        wrapper.eq("t1.id", id);
        List<ArticleVo> articleList = this.baseMapper.queryArticleList(wrapper);

        if (articleList == null || articleList.isEmpty()) {
            return null;
        }
        ArticleVo article = articleList.get(0);

        // 1.浏览数增加1
        article.setViewNum(article.getViewNum() + 1);
        this.updateById(article);

        return article;



        /*Article article =this.getById(id);

        if (article == null) {
            throw new RestException("该文章不存在");
        }

        // 1.浏览数增加1
        article.setViewNum(article.getViewNum() + 1);
        this.updateById(article);

        JSONObject json = new JSONObject();
        json.put("article", article);

        // 2.设置文章作者信息
        User user = userService.getById(article.getUserId());
        JSONObject author = new JSONObject();
        author.put("nickname", user.getNickname());
        author.put("avatar", user.getAvatar());
        author.put("id",user.getId());
        json.put("author", author);

        // 3.设置种类
        Category category = categoryService.getById(article.getCategoryId());
        json.put("category", category);

        // 4.设置标签
        List<Tag> tags = articleTagService.queryArticleTags(article.getId());
        json.put("tags", tags);

        return json;*/
    }

    @Override
    @Transactional
    public Integer updateArticle(User user, JSONObject json) {

        // 判断权限
        Article article = this.getById(json.getInteger("id"));
        if (article == null || !user.getId().equals(article.getUserId())) {
            throw new RestException("用户没有权限编辑这篇文章或者文章ID存在错误");
        }

        // 更新文章
        this.updateById(generateArticle(user, json));

        // 更新标签
        JSONArray tags = json.getJSONArray("tags");
        Integer articleId = article.getId();

        if (!CollectionUtils.isEmpty(tags)) {
            QueryWrapper<ArticleTag> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("article_id", articleId);
            articleTagService.remove(queryWrapper);
            articleTagService.saveBatch(generateArticleTag(tags, articleId));
        }
        return articleId;
    }

    @Override
    @Transactional
    public Integer addArticle(User user, JSONObject json) {

        Article article = generateArticle(user, json);
        article.setViewNum(0);
        article.setCommentNum(0);
        // 保存文章
        Integer id = this.baseMapper.insert(article);
        // 保存标签
        JSONArray tags = json.getJSONArray("tags");

        if (!CollectionUtils.isEmpty(tags)) {
            articleTagService.saveBatch(generateArticleTag(tags, article.getId()));
        }

        return article.getId();
    }

    @Override
    @Transactional
    public void deleteArticle(Long id) {

        // 删除标签
        QueryWrapper<ArticleTag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("article_id", id);
        articleTagService.remove(queryWrapper);

        // 删除文章
        this.removeById(id);
    }

    /**
     * 条件查询分页
     *
     * @param params
     * @return
     */
    @Override
    public Map<String, Object> queryPage(Map<String, Object> params) {
        QueryWrapper<ArticleVo> entityWrapper = new QueryWrapper<>();
        String categoryIdStr = (String) params.get("categoryId");
        if (StringUtils.isNotBlank(categoryIdStr)) {
            Integer categoryId = Integer.parseInt(categoryIdStr);
            entityWrapper.eq("category_id", categoryId);
        }

        String year = (String) params.get("year");
        String month = (String) params.get("month");
        if (StringUtils.isNotBlank(year) && StringUtils.isNotBlank(month)) {
            entityWrapper.eq("year(t1.create_time)", year);
            entityWrapper.eq("month(t1.create_time)", month);
        }
        String s = (String) params.get("month");
        int page;
        int size;
        try{
            page = Integer.parseInt((String) params.get("page"));
            size = Integer.parseInt((String)params.get("size"));
            // 启用默认参数
            if (page < 0)
            {
                page = 0;
            }
            if (size < 1 || size > 300)
            {
                size = 10;
            }
        }catch (Exception e)
        {
            throw new RestException("分页参数错误:"+e.getMessage());
        }
        int count = baseMapper.selectCount(new QueryWrapper<Article>());
        List<ArticleVo> articleVo = baseMapper.queryArticleByWrepper(size * (page - 1), size, entityWrapper);
        Map map = new HashMap();
        map.put("total",count);
        map.put("data",articleVo);
        return map;
    }

    /**
     * 组装文章实体
     *
     * @param user
     * @param json
     * @return
     */
    private Article generateArticle(User user, JSONObject json) {
        // 转换JSON为Article对象
        Article entity = JSON.toJavaObject(json, Article.class);

        // 2、保存文章用户信息信息
        user = userService.getById(user.getId());
        entity.setUserId(user.getId());
        entity.setNickname(user.getNickname());
        return entity;
    }

    /**
     * 组装标签实体列表
     *
     * @param tagArray
     * @param articleId
     * @return
     */
    @Transactional
    public List<ArticleTag> generateArticleTag(JSONArray tagArray, Integer articleId) {
        // 判断空值
        if (CollectionUtils.isEmpty(tagArray)){
            return null;
        }
        // 去除重复元素
        Set<Object> tags = new HashSet<>();
        tags.addAll(tagArray);

        List<ArticleTag> articleTagList = new ArrayList<>();
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        List<Tag> tagList = tagService.list(wrapper.in("name", tags));

        // 加入已存在数据库中的tagId
        for (Tag tag : tagList) {
            Integer tagId = tag.getId();
            ArticleTag articleTag = new ArticleTag();
            articleTag.setArticleId(articleId);
            articleTag.setTagId(tagId);
            articleTag.setUpdateTime(LocalDateTime.now());
            articleTagList.add(articleTag);
            tags.remove(tag.getName());
        }

        tagList = new LinkedList<>();
        for (Object tagName : tags) {
            Tag tag = new Tag();
            tag.setName((String) tagName);
            tagList.add(tag);
        }
        if (!CollectionUtils.isEmpty(tagList)) {
            tagService.saveBatch(tagList);
            tagList = tagService.list(wrapper.in("name", tags));

            // 加入已存在数据库中的tagId
            for (Tag tag : tagList) {
                Integer tagId = tag.getId();
                ArticleTag articleTag = new ArticleTag();
                articleTag.setArticleId(articleId);
                articleTag.setTagId(tagId);
                articleTag.setUpdateTime(LocalDateTime.now());
                articleTagList.add(articleTag);
            }
        }

        return articleTagList;
    }
}
