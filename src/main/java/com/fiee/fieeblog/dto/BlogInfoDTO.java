package com.fiee.fieeblog.dto;

import com.fiee.fieeblog.entity.Page;
import com.fiee.fieeblog.vo.PageVO;
import com.fiee.fieeblog.vo.WebsiteConfigVO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author: Fiee
 * @ClassName: BlogInfoDTO
 * @Date: 2023/4/1
 * @Version: v1.0.0
 **/
@Data
@Builder
public class BlogInfoDTO {
    /**
     * 文章数量
     */
    private Integer articleCount;

    /**
     * 分类数量
     */
    private Integer categoryCount;

    /**
     * 标签数量
     */
    private Integer tagCount;

    /**
     * 访问量
     */
    private Integer viewsCount;

    /**
     * 网站配置
     */
    private WebsiteConfigVO websiteConfig;

    /**
     * 页面列表
     */
    private List<Page> pageList;
}
