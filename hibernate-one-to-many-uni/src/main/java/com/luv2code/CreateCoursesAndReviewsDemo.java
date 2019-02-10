package com.luv2code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {

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

      Instructor ins = new Instructor("Vitor", "Vezani", "vitor.vezani@gmail.com");
      InstructorDetail insDetail = new InstructorDetail("senhoresGames", "airsoft");

      Course course1 = new Course("Just do it them!!");
      
      // Add reviews
      Review rev = new Review("This game is so good!");
      
      ins.add(course1);
            
      course1.addReview(rev);     
      
      ins.setInstructorDetail(insDetail);

      session.save(ins);
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
