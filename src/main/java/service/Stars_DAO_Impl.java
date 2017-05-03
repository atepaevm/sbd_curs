package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by 12 on 24.10.2017.
 */
public class Stars_DAO_Impl implements Stars_DAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void save(Stars p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
    public void update(Stars p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Stars emp = (Stars) session.load(Stars.class, p.getObject_id());
        //emp.setObject_class_name(p.getObject_class_name());
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        sessionFactory.close();
    }
    public void delete(Stars p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Stars.class, p.getObject_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }
    public Stars read(Stars p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Stars) session.load(Stars.class, p.getObject_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<Stars> list() {
        Session session = this.sessionFactory.openSession();
        List<Stars> StarsList = session.createQuery("from Stars").list();
        session.close();
        return StarsList;
    }
}
