package com.fiee.fieeblog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.dto.MessageDTO;
import com.fiee.fieeblog.entity.Message;
import com.fiee.fieeblog.service.MessageService;
import com.fiee.fieeblog.mapper.MessageMapper;
import com.fiee.fieeblog.utils.IpUtils;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Fiee
* @description 针对表【tb_message】的数据库操作Service实现
* @createDate 2023-04-12 20:06:00
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

    /**
     * 获取留言列表
     * @return
     */
    @Override
    public List<Message> getMessage() {
        LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Message::getIsReview,1);
        List<Message> list = this.list(wrapper);
        return list;
    }

    @Override
    public boolean saveMessage(Message message, HttpServletRequest request) {
        //获取留言用户的ip地址
        String ipAddress = IpUtils.getIpAddress(request);
        String ipSource = IpUtils.getIpSource(ipAddress);
        message.setIpAddress(ipAddress);
        message.setIpSource(ipSource);
        message.setUpdateTime(LocalDateTime.now());
        //保存
        return this.save(message);
    }

    /**
     * 获取留言-后台
     * @param vo
     * @return
     */
    @Override
    public PageResult<Message> getBackMessage(ConditionVO vo) {
        //留言总条数
        LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(vo.getKeywords()!=null,Message::getNickname,vo.getKeywords())
                .eq(vo.getIsReview()!=null,Message::getIsReview,vo.getIsReview());
        long count = this.count(wrapper);


        List<Message> messageList =
                baseMapper.getBackMessage(
                        (vo.getCurrent() - 1) * vo.getSize(),
                        vo.getSize(),
                        vo);

        return new PageResult<>(messageList,(int)count);
    }

    /**
     * 审核留言
     * @param ids
     * @return
     */
    @Override
    public boolean reviewMessages(List<Integer> ids) {
        List<Message> collect = ids.stream().map(
                        item -> Message.builder()
                                .id(item)
                                .isReview(1)
                                .build())
                .collect(Collectors.toList());
        System.out.println(collect);
        return this.updateBatchById(collect);
    }
}




