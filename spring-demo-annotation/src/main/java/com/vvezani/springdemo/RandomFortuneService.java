package com.vvezani.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

  private String[] randomFortunes = {"Fortune 1", "Fortune 2", "fortune 3", "Fortune 4"};

  @Override
  public String getFortune() {
    Random r = new Random();
    return randomFortunes[r.nextInt(randomFortunes.length)];
  }

}
