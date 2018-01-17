package com.vvezani.springdemo.coach;

public class VolleyCoach implements Coach {

  private String name;

  private String email;

  @Override
  public String getDailyWorkout() {
    return "55 Passes por dia";
  }

  @Override
  public String getDailyFortune() {
    return "Stub Fortune";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
