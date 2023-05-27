package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_comment】的数据库操作Mapper
* @createDate 2023-05-23 21:41:01
* @Entity com.fiee.fieeblog.entity.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> getCommentList(@Param("vo") ConditionVO vo, Long current, Long size);

    Integer count(@Param("vo") ConditionVO vo);
}




