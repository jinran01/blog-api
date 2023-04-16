package com.fiee.fieeblog.service;

import com.fiee.fieeblog.dto.BlogInfoDTO;
import com.fiee.fieeblog.entity.WebsiteConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fiee.fieeblog.vo.WebsiteConfigVO;

/**
* @author Fiee
* @description 针对表【tb_website_config】的数据库操作Service
* @createDate 2023-04-01 20:41:04
*/
public interface WebsiteConfigService extends IService<WebsiteConfig> {

    WebsiteConfigVO getWebsiteConfig();

    BlogInfoDTO getBlogInfo();

    boolean saveWebsiteConfig(WebsiteConfigVO vo);
}
