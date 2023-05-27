package com.fiee.fieeblog.service;

import com.fiee.fieeblog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;

/**
* @author Fiee
* @description 针对表【tb_comment】的数据库操作Service
* @createDate 2023-05-23 21:41:01
*/
public interface CommentService extends IService<Comment> {

    PageResult getCommentList(ConditionVO vo);
}
