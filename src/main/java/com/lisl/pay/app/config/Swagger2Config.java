package com.lisl.pay.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * com.vcread.unioncloud.balance.config.Swagger2Config
 * </p>
 * <p>
 * create_date : 2017/02/14 15:00
 * </p>
 * <p>
 * description :
 * </p>
 *  http://localhost:9090/swagger-ui.html#/
 *  访问需要登录
 * @author xiahuashun
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createProductApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("payApp")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lisl.pay.app"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("XX系统接口")
                .contact(new Contact("李先生", "www.xxx.com", "xxx@qq.com"))
                .version("1.0")
                .build();
    }


}
