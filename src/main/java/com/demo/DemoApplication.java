package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description
 * Create By   Patrick Leee
 * CreateTime  2018/3/21 下午2:15
 * UpdateTime  2018/3/21 下午2:15
 */
@ComponentScan(basePackages = {"com.demo.*"})
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        setRegisterErrorPageFilter(false);
        return builder.sources(DemoApplication.class);
    }

    public static void main(String[] args) {

        logger.debug("系统启动！");
        SpringApplication.run(DemoApplication.class, args);

    }
}

