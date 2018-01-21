package com.vvezani.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileRandomFortuneService implements FortuneService {

  @Value(value = "fortune1")
  private String fortune1;

  @Value(value = "fortune2")
  private String fortune2;

  @Value(value = "fortune3")
  private String fortune3;

  @Value(value = "fortune4")
  private String fortune4;

  private String[] randomFortunes = new String[4];

  public FileRandomFortuneService() {
    System.out.println("Executing default constructor FileRandomFortuneService method");
  }

  @Override
  public String getFortune() {
    Random r = new Random();
    return randomFortunes[r.nextInt(randomFortunes.length)];
  }

  @PostConstruct
  public void initValures() {
    System.out.println("Executing @PostConstruct method");
    randomFortunes[0] = fortune1;
    randomFortunes[1] = fortune2;
    randomFortunes[2] = fortune3;
    randomFortunes[3] = fortune4;
  }


  @PreDestroy
  public void preDestory() {
    System.out.println("Executing @PreDestroy method");
  }

}
