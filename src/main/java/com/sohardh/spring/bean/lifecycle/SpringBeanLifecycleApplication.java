package com.sohardh.spring.bean.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

  public static void main(String[] args) {
    System.out.println("\n--- Starting Spring Container ---");
    ConfigurableApplicationContext context =
        SpringApplication.run(SpringBeanLifecycleApplication.class, args);

    System.out.println("\n--- Phase 4: Application Running (Container is Active) ---\n");

    // Explicitly closing the context triggers Phase 5: Destruction
    System.out.println("--- Triggering Context Shutdown (Phase 5: Destruction) ---");
    context.close();
    System.out.println("--- Context Shutdown Complete ---\n");
  }
}
