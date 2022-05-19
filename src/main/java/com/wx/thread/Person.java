package com.wx.thread;

import java.util.Date;

/**
 * @Author i531869
 * @Date 8/29/21 8:06 PM
 * @Version 1.0
 */
public class Person {
  private String id;
  private String name;
  private String gender;
  private Integer age;
  private Date birth;

  private Dog dog = new Dog();

  public Person() {
    System.out.println("I am a person");
  }

  public static void main(String[] args) {
    ThreadLocal<String> local = new ThreadLocal<>();
    local.set("Jason");
    System.out.println("过了一段时间....");
    System.out.println(local.get());
    // Person p = new Person();
    // p.setName("唐雪菀");
    // System.out.println(p.getName());
    // System.out.println("hello world");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
