package com.fiee.fieeblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Comment;
import com.fiee.fieeblog.service.CommentService;
import com.fiee.fieeblog.mapper.CommentMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_comment】的数据库操作Service实现
* @createDate 2023-05-23 21:41:01
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Override
    public PageResult getCommentList(ConditionVO vo) {

        Integer count = baseMapper.count(vo);

        List<Comment> commentList = baseMapper.getCommentList(vo, (vo.getCurrent() - 1) * vo.getSize(), vo.getSize());

        return new PageResult<>(commentList,count);
    }
}




