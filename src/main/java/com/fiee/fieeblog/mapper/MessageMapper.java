package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_message】的数据库操作Mapper
* @createDate 2023-04-12 20:06:00
* @Entity com.fiee.fieeblog.entity.Message
*/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    List<Message> getBackMessage(Long current, Long size, @Param("vo") ConditionVO vo);
}




