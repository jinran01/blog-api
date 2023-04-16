package com.fiee.fieeblog.service;

import com.fiee.fieeblog.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.ConditionVO;
import com.fiee.fieeblog.vo.PageResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Fiee
* @description 针对表【tb_message】的数据库操作Service
* @createDate 2023-04-12 20:06:00
*/
public interface MessageService extends IService<Message> {
    List<Message> getMessage();

    boolean saveMessage(Message message, HttpServletRequest request);

    PageResult<Message> getBackMessage(ConditionVO vo);

    boolean reviewMessages(List<Integer> ids);
}
