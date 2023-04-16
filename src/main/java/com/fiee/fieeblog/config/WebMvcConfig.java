package com.fiee.fieeblog.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fiee.fieeblog.entity.Resource;
import com.fiee.fieeblog.filter.JwtInterceptor;
import com.fiee.fieeblog.handle.WebMvcHandler;
import com.fiee.fieeblog.service.ResourceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Fiee
 * @ClassName: WebMvcConfig
 * @Date: 2023/4/1
 * @Version: v1.0.0
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcHandler getWebMvcHandlerHandler() {
        return new WebMvcHandler();
    }

    @Autowired
    private ResourceService resourceService;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOriginPatterns("*")
                .allowedMethods("*");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getWebMvcHandlerHandler());
        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns(getResource());
    }
    //TODO
    List<String> getResource(){
        LambdaQueryWrapper<Resource> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Resource::getIsAnonymous,1);
        List<Resource> list = resourceService.list(wrapper);
        List<String> patterns = new ArrayList<>();
        for (Resource resource: list) {
            patterns.add(resource.getUrl());
        }
        return patterns;
    }
}
