package com.example.restdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
/**Configuracion swagger

 * HTML: http://localhost:8080/swagger-ui/
 *
 */



@Configuration
public class Swagger {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }
    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Api Rest",
                "Api rest docs for ",
                "1.0",
                "Google.com",
                new Contact("Johan", "github", "alfaro.ruiz.johan@gmail.com"),
                "MIT",
                "google.com",
                Collections.emptyList());

    }

}
