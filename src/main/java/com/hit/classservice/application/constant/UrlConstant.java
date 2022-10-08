package com.hit.classservice.application.constant;

public class UrlConstant {

  private UrlConstant() {
  }

  public static final class Category {
    private Category() {
    }

    private static final String PREFIX = "/category";
    public static final String LIST = "categories";
    public static final String GET = PREFIX + "/{id}";
  }

  public static final class Subject {

    private Subject() {
    }

    private static final String PREFIX ="/subject";
    public static final String LIST = "subjects";
    public static final String GET = PREFIX + "/{id}";
    public static final String UPDATE = PREFIX;

    public static final String DELETE = PREFIX + "/{id}";
  }

}
