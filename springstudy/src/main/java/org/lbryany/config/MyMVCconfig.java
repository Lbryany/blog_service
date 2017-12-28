package org.lbryany.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("org.lbryany")
public class MyMVCconfig implements WebMvcConfigurer {

    /**
     * 静态资源配置
     * @param registry ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/public", "classpath:/static/");
    }

    /**
     * 配置dbcp数据源
     * @return BasicDataSource
     */
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/javatest");
        ds.setUsername("root");
        ds.setPassword("489415783b");
        ds.setInitialSize(5);
        return ds;
    }
}
