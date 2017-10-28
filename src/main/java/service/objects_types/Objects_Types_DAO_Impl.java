package service.objects_types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.Objects_Classes.Objects_Classes;

import java.util.List;


public class Objects_Types_DAO_Impl implements Objects_Types_DAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void save(Objects_types p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
    public void update(Objects_types p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Objects_types emp = (Objects_types) session.load(Objects_types.class, p.getObject_type_id());
        emp=p;
       // emp.setObject_class_name(p.getObject_class_name());
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        sessionFactory.close();
    }
    public void delete(Objects_types p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Objects_types.class, p.getObject_type_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }

    public Objects_types read(Objects_types obj) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Objects_types) session.load(Objects_types.class, obj.getObject_type_id());
    }

    public Objects_Classes read(Objects_Classes p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Objects_Classes) session.load(Objects_Classes.class, p.getObject_class_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<Objects_types> list() {
        Session session = this.sessionFactory.openSession();
        List<Objects_types> Objects_ClassesList = session.createQuery("from Objects_types").list();
        session.close();
        return Objects_ClassesList;
    }

}