package com.vvezani.springdemo.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vvezani.springdemo.Coach;
import com.vvezani.springdemo.config.AppConfig;

public class JavaAnnotationDemoApp {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

    Coach bean = ctx.getBean("swimCoach", Coach.class);

    System.out.println(bean.getDailyWorkout());
    System.out.println(bean.getDailyFortune());

    ctx.close();

  }

}
