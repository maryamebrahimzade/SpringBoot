package com.example.hibernate.ormapping.onetoone.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddingEntryunidirectionalDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("/home/maryam/Java/hibernate/src/main/java/com/example/hibernate/ormapping/onetoone/ProjectConfig.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentGfgDetail.class)
                .buildSessionFactory();
        try (factory; Session session = factory.openSession()) {
            StudentGfgDetail studentGfgDetail = new StudentGfgDetail("GFG College", 19);
            Student student = new Student("asma", "amiri", "asma@gmail.com", studentGfgDetail);

            session.beginTransaction();

            // Save the student object.
            // This will also save the StudentGfgDetail
            // object as we have used CascadeType.ALL
            session.save(student);
            session.getTransaction().commit();
            System.out.println(
                    "Transaction Successfully Completed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
