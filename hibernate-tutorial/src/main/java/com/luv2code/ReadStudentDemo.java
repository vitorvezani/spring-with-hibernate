package com.luv2code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class ReadStudentDemo {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {
      session.beginTransaction();

      Student student = session.get(Student.class, 1L);

      System.out.println(student);

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
