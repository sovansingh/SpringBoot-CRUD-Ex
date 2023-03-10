package com.app.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("springboot-curd-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}
	
	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api/employees.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("springboot-curd-api")
				.description("Demo project for Spring Boot Restful Webservices")
				.termsOfServiceUrl("http://facebook.com")
//				.contact("")
//				.license("")
//				.licenseUrl("")
				.version("1.0")
				.build();
	}
}
