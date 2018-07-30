package com.vvezani.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vvezani.springdemo.Coach;

public class XmlAnnotationDemoApp {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    Coach bean = ctx.getBean(Coach.class);

    System.out.println(bean.getDailyFortune());
    System.out.println(bean.getDailyWorkout());

    ctx.close();

  }

}
