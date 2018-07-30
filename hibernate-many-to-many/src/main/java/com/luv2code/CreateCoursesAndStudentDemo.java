package com.luv2code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Student student1 = new Student("Vitor", "Vezani", "vitor.vezani@gmail.com");
			Course course = new Course("Analise de Algoritmo");
			session.save(course);
			
			course.addStudent(student1);

			session.save(student1);
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
