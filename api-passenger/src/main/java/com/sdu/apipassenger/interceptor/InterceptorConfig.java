package com.sdu.apipassenger.interceptor;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LHP
 * @date 2023-07-11 10:36
 * @description
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                // 拦截的路径（所有请求）
                .addPathPatterns("/**")
                // 不拦截的路径
                .excludePathPatterns("/noAuthTest/**")
                .excludePathPatterns("/verification-code")
                .excludePathPatterns("/verification-code-check");
    }


}
