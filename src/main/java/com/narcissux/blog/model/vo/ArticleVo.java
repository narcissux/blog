package com.narcissux.blog.model.vo;

import com.narcissux.blog.model.entity.Article;
import com.narcissux.blog.model.entity.Category;
import com.narcissux.blog.model.entity.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class ArticleVo extends Article{
    // 标签
    private List<Tag> tags;

    // 分类
    private Category category;

    @Override
    public String toString() {
        return "ArticleVo{" +
                "tags=" + tags +
                ", category=" + category +
                "} " + super.toString();
    }
}
