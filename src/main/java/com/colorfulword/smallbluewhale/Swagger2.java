package com.colorfulword.smallbluewhale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8888/smallbluewhale/swagger-ui.html
 * Created by jone.sun on 2017/6/30.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.colorfulword.smallbluewhale.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Smallbluewhale中所有APIs")
                .description("小蓝鲸后端 api列表")
                .termsOfServiceUrl("http://localhost:8888/smallbluewhale/swagger-ui.html")
                .contact("Colorfulword Team")
                .version("1.0")
                .build();
    }

}
