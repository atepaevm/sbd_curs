package service.objects_scientists;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.Objects_Classes.Objects_Classes;

import java.util.List;


public class Objects_Scientists_DAO_Impl implements Objects_Scientists_DAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void save(Objects_scientists p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
    public void update(Objects_scientists p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Objects_scientists emp = (Objects_scientists) session.load(Objects_scientists.class, p.getObject_id());
        emp=p;
       // emp.setObject_class_name(p.getObject_class_name());
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        sessionFactory.close();
    }
    public void delete(Objects_scientists p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Objects_scientists.class, p.getObject_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }

    public Objects_scientists read(Objects_scientists obj) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Objects_scientists) session.load(Objects_scientists.class, obj.getObject_id());
    }

    public Objects_Classes read(Objects_Classes p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Objects_Classes) session.load(Objects_Classes.class, p.getObject_class_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<Objects_scientists> list() {
        Session session = this.sessionFactory.openSession();
        List<Objects_scientists> Objects_ClassesList = session.createQuery("from service.objects_scientists.Objects_scientists").list();
        session.close();
        return Objects_ClassesList;
    }

}