package com.vvezani.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vvezani.springdemo.coach.VolleyCoach;

public class PropertiesFileMainApp {

  public static void main(String[] args) {
    // load the spring bean configuration file
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from spring container
    VolleyCoach coach = ctx.getBean("propertieVolleyCoach", VolleyCoach.class);

    // calling the method
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getName());
    System.out.println(coach.getEmail());

    // close the appContext
    ctx.close();
  }
}
