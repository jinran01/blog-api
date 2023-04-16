package com.fiee.fieeblog.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: Fiee
 * @ClassName: MessageDTO
 * @Date: 2023/4/12
 * @Version: v1.0.0
 **/
@Data
@Builder
public class MessageDTO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 留言内容
     */
    private String messageContent;

    /**
     * 弹幕速度
     */
    private Integer time;
}
