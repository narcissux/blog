package com.narcissux.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资源信息表(菜单,资源)
 * </p>
 *
 * @author xiaye
 * @since 2019-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Resource implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 资源ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 资源名称
     */
    @TableField("CODE")
    private String code;

    /**
     * 资源描述
     */
    @TableField("NAME")
    private String name;

    /**
     * 父资源编码->菜单
     */
    @TableField("PARENT_ID")
    private Integer parentId;

    /**
     * 访问地址URL
     */
    @TableField("URI")
    private String uri;

    /**
     * 类型 1:菜单menu 2:资源element(rest-api) 3:资源分类
     */
    @TableField("TYPE")
    private Integer type;

    /**
     * 访问方式 GET POST PUT DELETE PATCH
     */
    @TableField("METHOD")
    private String method;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 状态   1:正常、9：禁用
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;


}
