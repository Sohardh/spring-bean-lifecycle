package com.sohardh.spring.bean.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class AnnotationService {

  public AnnotationService() {
    // Phase 1: Instantiation
    System.out.println("[AnnotationService] 1. Instantiation: Constructor called.");
  }

  // Phase 3: Initialization
  @PostConstruct
  public void setup() {
    System.out.println("[AnnotationService] 3. Initialization: @PostConstruct called.");
  }

  // Phase 5: Destruction
  @PreDestroy
  public void cleanup() {
    System.out.println("[AnnotationService] 5. Destruction: @PreDestroy called.");
  }
}
