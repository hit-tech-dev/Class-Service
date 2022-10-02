package com.hit.classservice.config;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.hit.classservice.application.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomJacksonConverter {

  @Value("${spring.profiles.active:null}")
  private String env;

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
    return builder -> builder.annotationIntrospector(new JacksonAnnotationIntrospector() {
      @Override
      public boolean hasIgnoreMarker(AnnotatedMember m) {
        return CommonConstant.PRODUCT_ENV.equalsIgnoreCase(env);
      }
    });
  }

}
