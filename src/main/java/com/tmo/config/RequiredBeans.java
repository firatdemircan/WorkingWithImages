package com.tmo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CreatedBy pureevill
 * CreatedDate 15.03.2023 4:52 PM
 * CreatedFor WorkingWithImages
 */
@Configuration
public class RequiredBeans implements WebMvcConfigurer {

    final Environment environment;

    public RequiredBeans(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        String location = environment.getProperty("app.file.storage.mapping");

        registry.addResourceHandler("/uploads/**").addResourceLocations(location);
    }

}
