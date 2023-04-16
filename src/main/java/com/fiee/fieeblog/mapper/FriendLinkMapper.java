package com.fiee.fieeblog.mapper;

import com.fiee.fieeblog.entity.FriendLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_friend_link】的数据库操作Mapper
* @createDate 2023-04-08 16:22:37
* @Entity com.fiee.fieeblog.entity.FriendLink
*/
@Mapper
public interface FriendLinkMapper extends BaseMapper<FriendLink> {
    List<FriendLink> getFriendLink(Long current, Long size, @Param("vo") ConditionVO vo);
}




