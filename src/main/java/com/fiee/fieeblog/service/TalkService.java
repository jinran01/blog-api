package com.fiee.fieeblog.service;

import com.fiee.fieeblog.dto.TalkBackDTO;
import com.fiee.fieeblog.entity.Talk;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;

/**
* @author Fiee
* @description 针对表【tb_talk】的数据库操作Service
* @createDate 2023-05-27 20:41:11
*/
public interface TalkService extends IService<Talk> {

    boolean saveOrUpdateTalk(Talk talk);

    PageResult<TalkBackDTO> listBackTalks(ConditionVO vo);

    TalkBackDTO getTalkById(Integer id);
}
