package com.vvezani.springdemo;

public class FootballCoach implements Coach {

  @Override
  public String getDailyWorkout() {
    return "Go Ronaldo!";
  }

  @Override
  public String getDailyFortune() {
    return null;
  }

}
