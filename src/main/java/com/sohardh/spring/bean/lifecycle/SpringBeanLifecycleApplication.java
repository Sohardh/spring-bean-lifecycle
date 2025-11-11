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
    System.out.println("\t--- PHASE 4: PROTOTYPE DEMONSTRATION ---");

    // 1. Request the first instance (Instantiates and Initializes)
    PrototypeService proto1 = context.getBean(PrototypeService.class);

    // 2. Request a second instance (Proves it runs the lifecycle AGAIN)
    PrototypeService proto2 = context.getBean(PrototypeService.class);

    // 3. Manually destroy the instances (Calling Phase 5)
    System.out.println("\n--- Manually Destroying Prototypes ---");
    context.getBeanFactory().destroyBean(proto1);
    context.getBeanFactory().destroyBean(proto2);

    // Explicitly closing the context triggers Phase 5: Destruction
    System.out.println("--- Triggering Context Shutdown (Phase 5: Destruction) ---");
    context.close();
    System.out.println("--- Context Shutdown Complete ---\n");
  }
}
