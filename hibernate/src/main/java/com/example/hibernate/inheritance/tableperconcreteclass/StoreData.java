package com.example.hibernate.inheritance.tableperconcreteclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("/home/maryam/Java/hibernate/src/main/java/com/example/hibernate/inheritance/ProjectConfig.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Contract.class)
                .addAnnotatedClass(Regular.class)
                .buildSessionFactory();
        try(factory; Session session=factory.getCurrentSession()){
            session.beginTransaction();
            Employee employee=new Employee();
            employee.setName("Maryam Ebrahimzade");

            Regular regular=new Regular();
            regular.setName("Zahra Amiri");
            regular.setSalary(50000);
            regular.setBonus(5);

            Contract contract=new Contract();
            contract.setName("Asma Amiri");
            contract.setPay_per_hour(1000);
            contract.setContract_duration("15 hours");

            session.persist(employee);
            session.persist(regular);
            session.persist(contract);
            session.getTransaction().commit();
            System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
