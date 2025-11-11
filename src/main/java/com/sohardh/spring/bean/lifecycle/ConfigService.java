package com.sohardh.spring.bean.lifecycle;

// Note: No @Component annotation here
public class ConfigService {

  public ConfigService() {
    // Phase 1: Instantiation
    System.out.println("[ConfigService] 1. Instantiation: Constructor called.");
  }

  // Phase 3: Initialization (Custom method name)
  public void customSetup() {
    System.out.println("[ConfigService] 3. Initialization: customSetup (initMethod) called.");
  }

  // Phase 5: Destruction (Custom method name)
  public void customCleanup() {
    System.out.println("[ConfigService] 5. Destruction: customCleanup (destroyMethod) called.");
  }
}
