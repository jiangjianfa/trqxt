package com.lsnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@WebAppConfiguration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = "com.lsnu.controller")
public class MySwaggerConfig {

    //配置了Swagger的Bean实例
    @Bean
    public Docket docket(Environment environment) {

        //获得环境是否是自己要的
        /*Profiles profile = Profiles.of("dev","test");
        Boolean b = environment.acceptsProfiles(profile);*/
        return  new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                //any 扫描所有包
                //none 不扫描
                //withClassAnnotation 扫描类上的注解
                //withMethodAnnotation 扫描方法上的注解
                //basePackage 扫描包中的注解
                .apis(RequestHandlerSelectors.basePackage("com.lsnu"))
                //过滤路径
                //.paths(PathSelectors.ant("/lsnu/**"))
                .build();
    }


    //配置Swagger信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("Destiny_Fa ","","1121489375@qq.com");
        return  new ApiInfo("Swagger Test文档",
                "swagger测试demo",
                "1.0" ,
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
