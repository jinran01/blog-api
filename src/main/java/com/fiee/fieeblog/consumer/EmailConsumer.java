package com.fiee.fieeblog.consumer;

import com.alibaba.fastjson.JSON;
import com.fiee.fieeblog.dto.EmailDTO;
import com.fiee.fieeblog.service.RedisService;
import com.fiee.fieeblog.utils.CommonUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static com.fiee.fieeblog.constant.MQPrefixConst.*;
import static com.fiee.fieeblog.constant.RedisPrefixConst.USER_CODE_KEY;

/**
 * @Author: Fiee
 * @ClassName: EmailConsumer
 * @Date: 2023/3/31
 * @Version: v1.0.0
 **/
@Component
@RabbitListener(queues = EMAIL_QUEUE)
public class EmailConsumer {

    @Value("${spring.mail.username}")
    private String email;
    @Resource
    private TemplateEngine templateEngine;
    @Resource
    private JavaMailSender javaMailSender;
    @Autowired
    private RedisService redisService;

    @RabbitHandler
    public void process(byte[] data) throws MessagingException {
        EmailDTO emailDTO = JSON.parseObject(new String(data), EmailDTO.class);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(email);
        mimeMessageHelper.setTo(emailDTO.getEmail());
        mimeMessageHelper.setSubject(emailDTO.getSubject());

        Context context = new Context();
        String code = (String) redisService.get(USER_CODE_KEY+emailDTO.getEmail());
        String msg = "您的验证码为 " + code + " ,有效期15分钟，请不要告诉他人哦！";
        context.setVariable("msg", msg);
        String content = templateEngine.process("MailCode.html", context);
        mimeMessageHelper.setText(content,true);
        javaMailSender.send(mimeMessage);
    }
}
