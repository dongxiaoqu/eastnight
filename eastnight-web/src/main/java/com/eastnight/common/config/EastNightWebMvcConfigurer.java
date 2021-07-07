package com.eastnight.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>标题：eastnight mvc 配置类</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：com.eastnight.common.config.EastNightWebMvcConfig</p>
 * <p>创建日期：2021/7/7 15:19</p>
 */
@Configuration
public class EastNightWebMvcConfigurer implements WebMvcConfigurer {
    /**
     * 增加控制器
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/console").setViewName("console");
        registry.addViewController("/index").setViewName("index");
    }

}
