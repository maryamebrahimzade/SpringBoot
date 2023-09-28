package com.example.hibernate.inheritance.tableperhierarchy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreTest {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("/home/maryam/Java/hibernate/src/main/java/com/example/hibernate/inheritance/ProjectConfig.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Sports_Car.class)
                .addAnnotatedClass(Taxi_Car.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession();) {
            Transaction transaction = session.beginTransaction();
            Car car = new Car();
            car.setName("Mercedes");
            car.setColor("Black");

            Sports_Car sportsCar = new Sports_Car();
            sportsCar.setName("Porsche");
            sportsCar.setColor("Blue");
            sportsCar.setMileage(20);
            sportsCar.setCost(5000000);

            Taxi_Car taxiCar = new Taxi_Car();
            taxiCar.setName("Innova");
            taxiCar.setColor("Yellow");
            taxiCar.setFarePerKm(7);
            taxiCar.setAvailable(true);
            session.save(car);
            session.save(sportsCar);
            session.save(taxiCar);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
