package com.luv2code;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class CreateStudentDemo {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {
      session.beginTransaction();

      String theDateOfBirthStr = "13/09/1991";
      Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

      Student std = new Student("Victor", "Vezani", "vitor.vezani@gmail.com", theDateOfBirth);

      session.save(std);

      session.getTransaction().commit();

    } catch (Exception e) {
      System.err.println("Erro ao salvar o objeto: " + e.getMessage());
      session.getTransaction().rollback();
    } finally {
      session.close();
      factory.close();
    }

  }

}
