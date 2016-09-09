package com.xiaody.spring_boot_demo.application;

import org.springframework.boot.SpringApplication;

public class MyApplication {

	public static void main(String[] args) {
		new SpringApplication(MyConfiguration.class).run(args);
	}

}
