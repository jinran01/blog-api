package com.fiee.fieeblog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.ibatis.annotations.Property;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 相册
 * @TableName tb_photo_album
 */
@Data
@TableName(value = "tb_photo_album")
public class PhotoAlbum implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 相册名
     */
    private String albumName;

    /**
     * 相册描述
     */
    private String albumDesc;

    /**
     * 相册封面
     */
    private String albumCover;

    /**
     * 是否删除
     */
    @TableLogic(value = "0",delval = "1")
    private Integer isDelete;

    /**
     * 状态值 1公开 2私密
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}