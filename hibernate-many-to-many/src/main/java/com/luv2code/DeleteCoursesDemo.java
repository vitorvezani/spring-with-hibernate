package com.luv2code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {

      session.beginTransaction();

      Instructor ins = new Instructor("Vitor", "Vezani", "vitor.vezani@gmail.com");
      InstructorDetail insDetail = new InstructorDetail("senhoresGames", "airsoft");

      Course course1 = new Course("Just do it!");
      Course course2 = new Course("Just do it 2!");

      ins.setInstructorDetail(insDetail);

      ins.add(course1);
      ins.add(course2);

      session.persist(ins);

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
