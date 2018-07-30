package com.luv2code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrintInstructorDemo {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {

      session.beginTransaction();

      InstructorDetail instructorDetail = session.find(InstructorDetail.class, 8L);

      System.out.println("instructorDetail: " + instructorDetail);
      System.out.println("instructor: " + instructorDetail.getInstructor());

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
