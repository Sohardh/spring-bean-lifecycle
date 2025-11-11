package com.sohardh.spring.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InterfaceService implements InitializingBean, DisposableBean {

  public InterfaceService() {
    // Phase 1: Instantiation
    System.out.println("[InterfaceService] 1. Instantiation: Constructor called.");
  }

  // Phase 3: Initialization
  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("[InterfaceService] 3. Initialization: afterPropertiesSet() called.");
  }

  // Phase 5: Destruction
  @Override
  public void destroy() throws Exception {
    System.out.println("[InterfaceService] 5. Destruction: destroy() called.");
  }
}
