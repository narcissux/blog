package com.narcissux.blog.service.impl;

import com.narcissux.blog.model.entity.Resource;
import com.narcissux.blog.mapper.ResourceMapper;
import com.narcissux.blog.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源信息表(菜单,资源) 服务实现类
 * </p>
 *
 * @author xiaye
 * @since 2019-05-12
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

}
