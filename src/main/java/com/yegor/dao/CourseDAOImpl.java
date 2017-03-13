package com.yegor.dao;

import com.yegor.entities.CourseEntity;
import com.yegor.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

/**
 * Created by YegorKost on 08.03.2017.
 */
public class CourseDAOImpl implements CourseDAO{
    @Override
    public void add(CourseEntity courseEntity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.save(courseEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public CourseEntity get(int id) {
        Session session = null;
        CourseEntity result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            result = session.get(CourseEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<CourseEntity> getAll() {
        Session session = null;
        List<CourseEntity> courseEntities = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            courseEntities = session.createNativeQuery("SELECT * FROM course;", CourseEntity.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
    }
        return courseEntities;
    }

    @Override
    public void update(CourseEntity courseEntity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(courseEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    @Override
    public void delete(CourseEntity courseEntity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.delete(courseEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            rollbackTransaction(session);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();

            }
        }

    }

    private void rollbackTransaction(Session session) {
        if (session.getTransaction().getStatus() == TransactionStatus.ACTIVE ||
                session.getTransaction().getStatus() == TransactionStatus.MARKED_ROLLBACK){
            session.getTransaction().rollback();
        }
    }
}
