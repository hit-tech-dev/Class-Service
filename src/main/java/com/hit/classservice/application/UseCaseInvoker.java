package com.hit.classservice.application;

import com.hit.classservice.application.input.Input;
import com.hit.classservice.application.output.Output;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class UseCaseInvoker {

  private final Class<?> implementClazz;
  private final Method handleMethod;
  private final Object instance;
  private final boolean hasTransaction;

  public UseCaseInvoker(ApplicationContext applicationContext, Class<?> implementClazz) {
    this.implementClazz = implementClazz;
    this.instance = applicationContext.getBean(implementClazz);
    this.hasTransaction = this.implementClazz.getAnnotation(Transactional.class) != null;
    Stream<Method> methods = Arrays.stream(this.instance.getClass().getMethods());
    this.handleMethod = methods.filter(x -> x.getName().equals("handle")).findFirst().get();
  }

  @SuppressWarnings("unchecked")
  public <TInput extends Input, TOutput extends Output> TOutput invoke(Input input)
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    return (TOutput) this.handleMethod.invoke(this.instance, input);
  }

}
