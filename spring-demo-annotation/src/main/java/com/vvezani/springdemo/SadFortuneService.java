package com.vvezani.springdemo;

public class SadFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "I'm so sad!";
  }

}
