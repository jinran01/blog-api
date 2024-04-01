package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.dto.TalkBackDTO;
import com.fiee.fieeblog.entity.Talk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_talk】的数据库操作Mapper
* @createDate 2023-05-27 20:41:11
* @Entity com.fiee.fieeblog.entity.Talk
*/
@Mapper
public interface TalkMapper extends BaseMapper<Talk> {
    List<TalkBackDTO> listBackTalks(Long current, Long size, @Param("vo") ConditionVO vo);

    TalkBackDTO getBackTalkById(Integer id);
}




