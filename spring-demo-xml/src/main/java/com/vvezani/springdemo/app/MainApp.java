package com.vvezani.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vvezani.springdemo.coach.Coach;

public class MainApp {

  public static void main(String[] args) {
    // load the spring bean configuration file
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from spring container
    Coach coach = ctx.getBean("optimisticBaseballCoach", Coach.class);

    // calling the method
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyFortune());

    // close the appContext
    ctx.close();
  }
}
