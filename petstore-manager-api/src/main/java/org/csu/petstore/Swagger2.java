package org.csu.petstore;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 简介: <b></b>
 * <br/>
 * 注意:
 * <br/>
 *
 * @author 李泰庆
 * @version 1.0
 * @email litaiqing@analysys.com.cn
 * @date: 2018/7/24 16:37
 * @since JDK 1.8
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.csu.petstore.controller"))
                //.paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("petstore")
                .description("")
                .version("1.0")
                .build();
    }

}