package com.fiee.fieeblog.service;

import com.fiee.fieeblog.entity.FriendLink;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;

/**
* @author Fiee
* @description 针对表【tb_friend_link】的数据库操作Service
* @createDate 2023-04-08 16:22:37
*/
public interface FriendLinkService extends IService<FriendLink> {

    PageResult<FriendLink> getFriendLinks(ConditionVO vo);
}
