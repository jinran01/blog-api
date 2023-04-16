package com.fiee.fieeblog.service.Impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiee.fieeblog.dto.BlogInfoDTO;
import com.fiee.fieeblog.entity.Page;
import com.fiee.fieeblog.entity.WebsiteConfig;
import com.fiee.fieeblog.service.*;
import com.fiee.fieeblog.mapper.WebsiteConfigMapper;
import com.fiee.fieeblog.vo.WebsiteConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.fiee.fieeblog.constant.RedisPrefixConst.*;

/**
 * @author Fiee
 * @description 针对表【tb_website_config】的数据库操作Service实现
 * @createDate 2023-04-01 20:41:04
 */
@Service
public class WebsiteConfigServiceImpl extends ServiceImpl<WebsiteConfigMapper, WebsiteConfig>
        implements WebsiteConfigService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;
    @Autowired
    private PageService pageService;

    /**
     * 获取博客配置信息
     *
     * @return
     */
    @Override
    public WebsiteConfigVO getWebsiteConfig() {
        WebsiteConfigVO websiteConfigVO;
        Object webConfig = redisService.get(WEBSITE_CONFIG);
        if (!Objects.isNull(webConfig)) {
            //从redis获取数据
            websiteConfigVO = JSON.parseObject(webConfig.toString(), WebsiteConfigVO.class);
        } else {
            WebsiteConfig config = this.getById(DEFAULT_BATCH_SIZE);
            String websiteConfig = config.getConfig();
            websiteConfigVO = JSON.parseObject(websiteConfig, WebsiteConfigVO.class);
            redisService.set(WEBSITE_CONFIG, websiteConfig);
        }
        return websiteConfigVO;
    }

    /**
     * 首页获取博客信息
     *
     * @return
     */
    @Override
    public BlogInfoDTO getBlogInfo() {
        //获取博客配置信息
        WebsiteConfigVO websiteConfig = this.getWebsiteConfig();
        //文章数量
        long article_count = articleService.count();
        //分类数量
        long category_count = categoryService.count();
        //标签数量
        long tag_count = tagService.count();
        //页面列表
        List<Page> pageList = pageService.list();

        return BlogInfoDTO.builder()
                .articleCount((int) article_count)
                .categoryCount((int) category_count)
                .tagCount((int) tag_count)
                .viewsCount(10)
                .pageList(pageList)
                .websiteConfig(websiteConfig)
                .build();
    }

    /**
     * 保存网站配置信息
     *
     * @return
     */
    @Override
    public boolean saveWebsiteConfig(WebsiteConfigVO vo) {
        //更新操作
        WebsiteConfig websiteConfig = WebsiteConfig.builder()
                .id(1)
                .config(JSON.toJSONString(vo))
                .build();
        this.updateById(websiteConfig);
        //设置redis缓存
        redisService.set(WEBSITE_CONFIG, JSON.toJSONString(vo));
        return true;
    }
}




