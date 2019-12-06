package kr.co.lunasoft.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		          .select()
		          .apis(RequestHandlerSelectors.basePackage("kr.co.lunasoft.controller"))
		          //.paths(PathSelectors.any())
		          .build()
		          .apiInfo(this.apiInfo());
	}
	
	private ApiInfo apiInfo() {
		 return new ApiInfoBuilder()
	                .title("DEAN BACKEND API")
	                .description("DEAN'S SPRINGBOOT API \r\n + Using Skill - Spring Boot, MySQL, redis, MongoDB, Kafka, Hystrix, Async \r\n + last updated on " + new Date())
	                .termsOfServiceUrl("https://github.com/insanezindol")
	                .contact(new Contact("Dean", "https://github.com/insanezindol", "leejinhyung90@gmail.com"))
	                .license("dean")
	                .licenseUrl("https://github.com/insanezindol")
	                .version("1.0")
	                .build();
	}
	
}
