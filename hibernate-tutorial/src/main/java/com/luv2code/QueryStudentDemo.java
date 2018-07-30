package com.luv2code;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class QueryStudentDemo {

  public static void main(String[] args) {

    SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {
      session.beginTransaction();

      List<Student> students = session.createQuery("from Student s where s.firstName = 'Victor'", Student.class).getResultList();
      displayStudents(students);

      students = session.createQuery("from Student s where s.firstName='Victor' or firstName='Vitor'", Student.class).getResultList();
      displayStudents(students);

      students = session.createQuery("from Student s where s.firstName LIKE '%Vi%'", Student.class).getResultList();
      displayStudents(students);

      session.getTransaction().commit();

    } catch (Exception e) {
      System.err.println("Erro ao salvar o objeto: " + e.getMessage());
      session.getTransaction().rollback();
    } finally {
      session.close();
      factory.close();
    }

  }

  private static void displayStudents(List<Student> students) {
    for (Student student : students) {
      System.out.println(student);
    }
  }

}
