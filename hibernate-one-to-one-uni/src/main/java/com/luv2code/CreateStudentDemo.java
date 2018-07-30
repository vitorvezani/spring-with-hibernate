package com.luv2code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {

      session.beginTransaction();

      Instructor inst = new Instructor("Vitor", "Vezani", "vitor.vezani@gmail.com");
      InstructorDetail instDetail = new InstructorDetail("primosgamers", "airsoft");

      inst.setInstructorDetail(instDetail);

      session.save(inst);

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
