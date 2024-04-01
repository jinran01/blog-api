package com.fiee.fieeblog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.dto.TalkBackDTO;
import com.fiee.fieeblog.entity.Talk;
import com.fiee.fieeblog.service.TalkService;
import com.fiee.fieeblog.mapper.TalkMapper;
import com.fiee.fieeblog.utils.CommonUtils;
import com.fiee.fieeblog.utils.PageUtils;
import com.fiee.fieeblog.utils.UserUtils;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Fiee
 * @description 针对表【tb_talk】的数据库操作Service实现
 * @createDate 2023-05-27 20:41:11
 */
@Service
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk>
        implements TalkService {

    @Override
    public boolean saveOrUpdateTalk(Talk talk) {
        talk.setUserId(UserUtils.getLoginUser().getUserInfoId());
        return this.saveOrUpdate(talk);
    }

    @Override
    public PageResult<TalkBackDTO> listBackTalks(ConditionVO vo) {
        // 查询说说总量
        Integer count = Math.toIntExact(baseMapper.selectCount(new LambdaQueryWrapper<Talk>()
                .eq(Objects.nonNull(vo.getStatus()), Talk::getStatus, vo.getStatus())));
        if (count == 0) {
            return new PageResult<>();
        }

        // 分页查询说说
        List<TalkBackDTO> talkDTOList = baseMapper.listBackTalks((vo.getCurrent() - 1) * vo.getSize(), vo.getSize(), vo);
        talkDTOList.forEach(item -> {
            // 转换图片格式
            if (Objects.nonNull(item.getImages())) {
                item.setImgList(JSONArray.parseArray(item.getImages()));
            }
        });
        return new PageResult<>(talkDTOList, count);
    }

    @Override
    public TalkBackDTO getTalkById(Integer id) {
        TalkBackDTO talkBackDTO = baseMapper.getBackTalkById(id);
        // 转换图片格式
        if (Objects.nonNull(talkBackDTO.getImages())) {
            talkBackDTO.setImgList(CommonUtils.castList(JSON.parseObject(talkBackDTO.getImages(), List.class), String.class));
        }
        return null;
    }
}




