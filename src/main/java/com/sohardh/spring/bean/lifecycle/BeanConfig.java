package com.sohardh.spring.bean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  // Explicitly define ConfigService and pass the custom method names
  @Bean(initMethod = "customSetup", destroyMethod = "customCleanup")
  public ConfigService configService() {
    return new ConfigService();
  }

}