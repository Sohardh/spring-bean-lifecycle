# Spring Bean Lifecycle Demo

This project demonstrates the lifecycle of Spring beans, showing the different phases a bean goes through from creation to destruction, and the various ways to hook into these lifecycle events.

## Overview

Spring beans go through several phases during their lifecycle:

1. **Instantiation**: The bean is created using its constructor
2. **Property Population**: Spring injects dependencies and sets properties
3. **Initialization**: Post-processing and custom initialization methods are called
4. **Usage**: The bean is available for use in the application
5. **Destruction**: Cleanup methods are called when the container is shutting down

This demo shows three different approaches to hooking into the bean lifecycle:

1. **Annotation-based**: Using `@PostConstruct` and `@PreDestroy` annotations
2. **Interface-based**: Implementing `InitializingBean` and `DisposableBean` interfaces
3. **Configuration-based**: Using `initMethod` and `destroyMethod` in `@Bean` definition

It also demonstrates the difference between singleton beans (default) and prototype beans.

## Project Structure

- `AnnotationService.java`: Demonstrates lifecycle hooks using annotations
- `InterfaceService.java`: Demonstrates lifecycle hooks using Spring interfaces
- `ConfigService.java`: Demonstrates lifecycle hooks using custom method names
- `BeanConfig.java`: Configuration class that defines the ConfigService bean with custom init/destroy methods
- `PrototypeService.java`: Demonstrates lifecycle for prototype-scoped beans
- `SpringBeanLifecycleApplication.java`: Main application that runs the demo

## Lifecycle Phases Demonstrated

### Phase 1: Instantiation
All beans show constructor execution during this phase.

### Phase 2: Property Population
This phase happens automatically (dependency injection).

### Phase 3: Initialization
Each service demonstrates a different way to hook into this phase:
- `AnnotationService`: Uses `@PostConstruct`
- `InterfaceService`: Implements `afterPropertiesSet()` from `InitializingBean`
- `ConfigService`: Uses a custom method specified in `@Bean(initMethod="customSetup")`

### Phase 4: Usage
The application is running and beans are available for use.

### Phase 5: Destruction
Each service demonstrates a different way to hook into this phase:
- `AnnotationService`: Uses `@PreDestroy`
- `InterfaceService`: Implements `destroy()` from `DisposableBean`
- `ConfigService`: Uses a custom method specified in `@Bean(destroyMethod="customCleanup")`

## Running the Demo

To run this demo:

```bash
./gradlew bootRun
```

Watch the console output to see the lifecycle phases in action. The application will:

1. Start the Spring container
2. Show initialization of singleton beans
3. Demonstrate prototype bean creation (multiple instances)
4. Manually destroy prototype beans
5. Shut down the container, triggering destruction callbacks

## Key Takeaways

1. Spring provides multiple ways to hook into bean lifecycle events
2. Choose the approach that best fits your application's needs:
   - Annotations for simplicity and readability
   - Interfaces for strict contracts
   - Configuration for external libraries or when you can't modify the source
3. Be aware of the differences between singleton and prototype beans, especially regarding destruction callbacks