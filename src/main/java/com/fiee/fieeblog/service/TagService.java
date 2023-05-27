package com.fiee.fieeblog.service;

import com.fiee.fieeblog.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_tag】的数据库操作Service
* @createDate 2023-04-09 21:11:19
*/
public interface TagService extends IService<Tag> {

    PageResult getTagList(ConditionVO vo);

    boolean removeBatch(List<Tag> asList);
}
