package com.fiee.fieeblog.service;

import com.fiee.fieeblog.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.CategoryVO;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_category】的数据库操作Service
* @createDate 2023-05-14 19:11:41
*/
public interface CategoryService extends IService<Category> {

    PageResult<CategoryVO> getCategoryList(ConditionVO vo);

    boolean removeBatch(List<Category> categories);
}
