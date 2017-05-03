package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Objects_Classes_DAO_Impl implements Objects_Classes_DAO{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void save(Objects_Classes p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
    public void update(Objects_Classes p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Objects_Classes emp = (Objects_Classes) session.load(Objects_Classes.class, p.getObject_class_id());
        emp.setObject_class_name(p.getObject_class_name());
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        sessionFactory.close();
    }
    public void delete(Objects_Classes p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Objects_Classes.class, p.getObject_class_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }
    public Objects_Classes read(Objects_Classes p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Objects_Classes) session.load(Objects_Classes.class, p.getObject_class_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<Objects_Classes> list() {
        Session session = this.sessionFactory.openSession();
        List<Objects_Classes> Objects_ClassesList = session.createQuery("from Objects_Classes").list();
        session.close();
        return Objects_ClassesList;
    }

}