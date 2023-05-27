package com.fiee.fieeblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.entity.Talk;
import com.fiee.fieeblog.service.TalkService;
import com.fiee.fieeblog.mapper.TalkMapper;
import com.fiee.fieeblog.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Fiee
* @description 针对表【tb_talk】的数据库操作Service实现
* @createDate 2023-05-27 20:41:11
*/
@Service
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk>
    implements TalkService{

    @Override
    public boolean saveOrUpdateTalk(Talk talk) {
        talk.setUserId(UserUtils.getLoginUser().getUserInfoId());
        return this.saveOrUpdate(talk);
    }
}




