package com.yegor.dao;

import com.yegor.entities.CourseEntity;
import com.yegor.entities.StudentEntity;
import com.yegor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 * Created by YegorKost on 09.03.2017.
 */
class TestedDB {

    static void initDb() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            NativeQuery query = session.createNativeQuery(
                    "CREATE TABLE course (" +
                            "course_id SERIAL NOT NULL, " +
                            "name CHARACTER VARYING NOT NULL, " +
                            "CONSTRAINT course_pkey PRIMARY KEY (course_id)" +
                            ");\n" +
                    "CREATE TABLE student (" +
                            "student_id SERIAL NOT NULL, " +
                            "name CHARACTER VARYING NOT NULL, " +
                            "surname CHARACTER VARYING NOT NULL, " +
                            "phone_number CHARACTER(10), " +
                            "birthday date, " +
                            "email CHARACTER VARYING, " +
                            "course_id integer, " +
                            "CONSTRAINT student_pkey PRIMARY KEY (student_id), " +
                            "CONSTRAINT fk_course_id FOREIGN KEY (course_id) " +
                            "REFERENCES course (course_id)" +
                            ");"
            );
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            closeSession(session);
        }
    }

    static void setDBData(CourseEntity c1, CourseEntity c2, StudentEntity s1, StudentEntity s2) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            String queryString = "INSERT INTO course (name) VALUES (:n1), (:n2);\n" +
                    "INSERT INTO student (name, surname, phone_number, birthday, email, course_id) " +
                    "VALUES (:sn1, :ss1, :p1, :b1, :e1, :c1), (:sn2, :ss2, :p2, :b2, :e2, :c2);";
            NativeQuery query = session.createNativeQuery(queryString);
            query.setParameter("n1", c1.getName());
            query.setParameter("n2", c2.getName());

            query.setParameter("sn1", s1.getName());
            query.setParameter("ss1", s1.getSurname());
            query.setParameter("p1", s1.getPhoneNumber());
            query.setParameter("b1", s1.getBirthday());
            query.setParameter("e1", s1.getEmail());
            query.setParameter("c1", c1.getId());

            query.setParameter("sn2", s2.getName());
            query.setParameter("ss2", s2.getSurname());
            query.setParameter("p2", s2.getPhoneNumber());
            query.setParameter("b2", s2.getBirthday());
            query.setParameter("e2", s2.getEmail());
            query.setParameter("c2", c1.getId());

            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            closeSession(session);
        }

    }

    static void cleanDBData() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            String queryString = "DELETE FROM student;\n" +
                    "DELETE FROM course;\n" +
                    "ALTER SEQUENCE student_student_id_seq RESTART WITH 1;\n" +
                    "ALTER SEQUENCE course_course_id_seq RESTART WITH 1;";
            NativeQuery query = session.createNativeQuery(queryString);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            closeSession(session);
        }
    }

    static void deleteDB() {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            NativeQuery query = session.createNativeQuery("DROP TABLE IF EXISTS student;\n" +
                    "DROP TABLE IF EXISTS course;");
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            closeSession(session);
            if (sessionFactory != null && sessionFactory.isOpen()) {
                sessionFactory.close();
            }
        }

    }

    private static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    private static void rollbackTransaction(Session session) {
        if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE ||
                session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK) {
            session.getTransaction().rollback();
        }
    }

}
