package com.sohardh.spring.bean.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Sets this bean to Prototype scope
public class PrototypeService {

  public PrototypeService() {
    // Phase 1: Instantiation
    System.out.println("\t[PrototypeService] 1. Instantiation: Constructor called (New Instance!).");
  }

  @PostConstruct
  public void setup() {
    // Phase 3: Initialization
    System.out.println("\t[PrototypeService] 3. Initialization: @PostConstruct called.");
  }

  @PreDestroy
  public void cleanup() {
    // Phase 5: Destruction (This will ONLY be called manually)
    System.out.println("\t[PrototypeService] 5. Destruction: @PreDestroy called (Manual Cleanup).");
  }
}
