package service.objects_common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class Objects_Common_DAO_Impl implements Objects_Common_DAO {
    public void save(Objects_Common obj) {

    }

    public void update(Objects_Common obj) {

    }

    public void delete(Objects_Common obj) {

    }

    public Objects_Common read(Objects_Common obj) {
        return null;
    }

    public List<Objects_Common> list() {
        return null;
    }
/*
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void save(Objects_Common p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
    public void update(Objects_Common p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Objects_Common emp = (Objects_Common) session.load(Objects_Common.class, p.getObject_id());
        emp.setObject_class_name(p.getObject_class_name());
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        sessionFactory.close();

    }
    public void delete(Objects_Common p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Objects_Common.class, p.getObject_class_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }
    public Objects_Common read(Objects_Common p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Objects_Common) session.load(Objects_Common.class, p.getObject_class_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<Objects_Common> list() {
        Session session = this.sessionFactory.openSession();
        List<Objects_Common> Objects_ClassesList = session.createQuery("from Objects_Classes").list();
        session.close();
        return Objects_ClassesList;
    }
*/
}
