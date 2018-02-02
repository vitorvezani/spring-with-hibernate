package com.luv2code.springdemo.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

  private String firstname;
  private String lastname;

  private String country;

  private String ocupation;

  private String favoriteLanguage;

  private String[] operationSystems;

  private List<String> ocupations = new ArrayList<>();

  public Student() {
    ocupations.add("Estudante");
    ocupations.add("Trabalhador");
    ocupations.add("Dono de Casa");
  }

  public String getFirstname() {
    return firstname;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public List<String> getOcupations() {
    return ocupations;
  }

  public void setOcupations(List<String> ocupations) {
    this.ocupations = ocupations;
  }

  public String getOcupation() {
    return ocupation;
  }

  public void setOcupation(String ocupation) {
    this.ocupation = ocupation;
  }

  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public void setFavoriteLanguage(String favorateLanguage) {
    this.favoriteLanguage = favorateLanguage;
  }

  public String[] getOperationSystems() {
    return operationSystems;
  }

  public void setOperationSystems(String[] operationSystems) {
    this.operationSystems = operationSystems;
  }

  @Override
  public String toString() {
    return "Student [firstname=" + firstname + ", lastname=" + lastname + "]";
  }

}
