package com.fiee.fieeblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Category;
import com.fiee.fieeblog.service.CategoryService;
import com.fiee.fieeblog.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author Fiee
* @description 针对表【tb_category】的数据库操作Service实现
* @createDate 2023-04-09 21:08:26
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




