package study.clone.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

/**
 * swagger api doc 설정
 * @since 24.12.14 21:30
 */
@OpenAPIDefinition(
    info = @Info(
        title = "swag한 API 명세서",
        version = "alpha"
    ),
    tags = {
        @Tag(name = "01.Article", description = "게시글 기능"),
        @Tag(name = "02.Media", description = "미디어 기능"),
        @Tag(name = "03.Member", description = "사용자 기능, 현재는 러프하게 진행"),
    }
)
@Configuration
public class SwaggerConfig {
}
