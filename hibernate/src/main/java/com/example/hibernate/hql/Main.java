package com.example.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("Java_programming");
        book.setAuthor("Robert");
        BookCategory bookCategory = new BookCategory();
        bookCategory.setBookCategory("programming");
        book.setBookCategory(bookCategory);

        SessionFactory factory = new Configuration().configure("/home/maryam/Java/hibernate/src/main/java/com/example/hibernate/hql/ProjectConfig.xml")
                .buildSessionFactory();
        try (factory; Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            session.save(bookCategory);

            // Example of HQL to get all the records
            String hql1 = "from Book";
            Query q1 = session.createQuery(hql1);
            List<Book> allBook = q1.list();

            //Example of HQL to get just title field of the Book object
            String hql2 = "select b.title from Book b ";
            Query q2 = session.createQuery(hql2);
            List<String> bookTitle = q2.list();

            // Example of HQL to get records with pagination
            Query q3 = session.createQuery(hql1);
            q3.setFirstResult(5);
            q3.setMaxResults(10);
            List<Book> selectionOfBooks = q3.list();

            //Example of HQL update query
            String hql4 = "update Book set title=:titlevalue where id=:idvalue";
            Query q4 = session.createQuery(hql4);
            q4.setParameter("titlevalue", "Java_programming");
            q4.setParameter("idvalue", 1);
            int statusUpdate = q4.executeUpdate();
            System.out.println("Rows affected after Update: " + statusUpdate);

            // Example of HQL delete query
            String hql5 = "delete from Book where id=:idvalue";
            Query q5 = session.createQuery(hql5);
            q5.setParameter("idvalue", 1);
            int statusDelete = q5.executeUpdate();
            System.out.println("Rows affected after Delete: " + statusDelete);

            //Example of HQL to Insert Into records
            String hql6 = "insert into NewBook (title,author)" + "select b.title,b.author from Book b";
            Query q6 = session.createQuery(hql6);
            int result = q6.executeUpdate();
            System.out.println("Rows affected after InsertInto: " + result);


            //Example of HQL with Aggregate functions
            //to count total number of book ID
            String hql7 = "select count(id) from Book";
            Query q7 = session.createQuery(hql7);
            List<Integer> count = q7.list();
            System.out.println("Total number of book ID: " + count.get(0));

            //Example of HQL the ORDER BY
            String hql8 = "from Book b where b.id>:id " +
                    "ORDER BY b.title DESC, b.author DESC ";
            Query q8 = session.createQuery(hql8);
            q8.setParameter("id", 2);
            List<Book> resultOrderBy = q8.list();

            //Example of HQL the Group By
            String hql9 = "select count(b.id),b.title from Book b " +
                    "group by b.title";
            Query q9 = session.createQuery(hql9);
            List<Book> resultGroupBy = q9.list();


            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
