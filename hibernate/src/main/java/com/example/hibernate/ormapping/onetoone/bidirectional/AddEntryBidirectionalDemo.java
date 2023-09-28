package com.example.hibernate.ormapping.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddEntryBidirectionalDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("/home/maryam/Java/hibernate/src/main/java/com/example/hibernate/ormapping/onetoone/ProjectConfig.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentGfgDetail.class)
                .buildSessionFactory();
        // Create session object
        try (factory; Session session = factory.getCurrentSession();) {
            Student student = new Student("zahra", "amiri", "zahra@gmail.com");
            StudentGfgDetail studentGfgDetail = new StudentGfgDetail("GFG College", 20);
            studentGfgDetail.setStudent(student);

            session.beginTransaction();
            session.save(studentGfgDetail);
            session.getTransaction().commit();
            System.out.println(
                    "Transaction Successfully Completed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
