package com.example.hibernate.batchprocessing;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try{
            factory=new Configuration().configure("/home/maryam/Maryam-github/hibernate/src/main/java/com/example/hibernate/batchprocessing/ProjectConfig.xml").buildSessionFactory();
        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }
        ManageEmployee me=new ManageEmployee();
        /* Add employee records in batches */
        me.addEmployees();
    }

    /* Method to create employee records in batches */
    public void addEmployees(){
        Session session=factory.openSession();
        Transaction tx=null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            for (int i = 0; i < 100000; i++) {
                String fname = "First Name " + i;
                String lname = "Last Name " + i;
                Integer salary = i;
                Employee employee = new Employee(fname, lname, salary);
                session.save(employee);
                if (i % 50 == 0) {
                    session.flush(); //insert into DB
                    session.clear(); //session clear
                }
            }
            tx.commit();
        }catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return;
    }
}
