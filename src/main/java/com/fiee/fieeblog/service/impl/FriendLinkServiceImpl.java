package com.fiee.fieeblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.FriendLink;
import com.fiee.fieeblog.service.FriendLinkService;
import com.fiee.fieeblog.mapper.FriendLinkMapper;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_friend_link】的数据库操作Service实现
* @createDate 2023-04-08 16:22:37
*/
@Service
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkMapper, FriendLink>
    implements FriendLinkService{

    /**
     * 获取友链列表
     * @param vo
     * @return
     */
    @Override
    public PageResult<FriendLink> getFriendLinks(ConditionVO vo) {
        //列表总数
        long count = this.count();
        List<FriendLink> friendLink = baseMapper.getFriendLink((vo.getCurrent() - 1) * vo.getSize(), vo.getSize(), vo);
        return new PageResult<>(friendLink, (int) count);
    }
}




