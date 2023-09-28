package com.example.hibernate.fetchingstrategy.lazi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchLazyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("/home/maryam/Java/hibernate/src/main/java/com/example/hibernate/fetchingstrategy/ProjectConfig.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        try (factory; Session session = factory.getCurrentSession()) {
            Employee employee = new Employee();
            employee.setName("zahra");
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            session.close();
            employee.getAddress();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
