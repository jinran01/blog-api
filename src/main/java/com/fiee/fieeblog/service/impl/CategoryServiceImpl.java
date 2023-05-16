package com.fiee.fieeblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Category;
import com.fiee.fieeblog.service.CategoryService;
import com.fiee.fieeblog.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author Fiee
* @description 针对表【tb_category】的数据库操作Service实现
* @createDate 2023-05-14 19:11:41
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




