package com.luv2code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class DeleteStudentDemo {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {
      session.beginTransaction();

      int executeUpdate = session.createQuery("delete from Student where id=1").executeUpdate();
      System.out.println(executeUpdate + " lines were deleted!");
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
