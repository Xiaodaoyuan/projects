package com.xiaody.spring_boot_demo.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:spring/application.xml"})
@ComponentScan(basePackages = {"com.xiaody.spring_boot_demo"})
@EnableAutoConfiguration
public class MyConfiguration {

}
