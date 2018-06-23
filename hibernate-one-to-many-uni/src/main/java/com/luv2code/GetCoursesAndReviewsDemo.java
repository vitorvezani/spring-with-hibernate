package com.luv2code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesAndReviewsDemo {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .addAnnotatedClass(Review.class)
                                .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {

      session.beginTransaction();

      Course course = session.get(Course.class, 13);
      
      System.out.println(course);
      System.out.println(course.getReviews());
      
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
