package com.hit.classservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Value("${springdoc.server.url}")
  private String serverUrl;

  @Value("${springdoc.server.is_rewrite_by_gateway}")
  private boolean isRewriteByGateway;

  @Bean
  public OpenAPI customOpenAPI() {
    OpenAPI openAPI = new OpenAPI().info(
        new Info()
            .title("Class Service API")
            .version("1.0")
            .description("Documentation Class Service API v1.0")
    );

    if (isRewriteByGateway && StringUtils.isNotEmpty(serverUrl)) {
      openAPI.addServersItem(new Server().url(serverUrl));
      openAPI.addSecurityItem(new SecurityRequirement().addList("gateway security"));
      openAPI.components(
          new Components()
              .addSecuritySchemes(
                  "gateway security",
                  new SecurityScheme().name("gateway security").type(SecurityScheme.Type.HTTP).scheme("basic")
              )
      );
    }

    return openAPI;
  }

}
