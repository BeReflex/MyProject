package cn.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaApplication class
 * 启动类
 * @author Administrator
 * @date 2019/1/21
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

 
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
