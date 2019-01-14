/*
 * @(#)SpringBootWebApplication.java
 *
 * Copyright 2018
 */
package org.xjulio.mb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;

/**
 * @author <a href="mailto:xjulio@gmail.com">Julio Cesar Damasceno</a>
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.xjulio.mb"})
@EnableSpringBootMetricsCollector
@EnablePrometheusEndpoint
public class SpringBootWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}