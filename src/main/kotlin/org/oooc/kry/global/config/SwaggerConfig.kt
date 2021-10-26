package org.oooc.kry.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun auth(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .groupName("auth")
            .select()
            .paths(PathSelectors.ant("/auth/**"))
            .build()
    }

    @Bean
    fun board(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .groupName("board")
            .select()
            .paths(PathSelectors.ant("/board/**"))
            .build()
    }

    @Bean
    fun problem(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .groupName("problem")
            .select()
            .paths(PathSelectors.ant("/problem/**"))
            .paths(PathSelectors.ant("/problemset/**"))
            .build()
    }
}
