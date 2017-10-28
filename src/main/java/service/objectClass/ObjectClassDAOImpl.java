package service.objectClass;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ObjectClassDAOImpl implements ObjectClassDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void save(ObjectClass p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    public ObjectClass findOne(Integer id){
        Session session = this.sessionFactory.openSession();
        ObjectClass retVal = (ObjectClass) session.createQuery("From ObjectClass WHERE id = :id").setParameter("id", id).list().get(0);
        session.close();
        return retVal;
    }

    public void update(ObjectClass p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        ObjectClass emp = (ObjectClass) session.load(ObjectClass.class, p.getObject_class_id());
        emp.setObject_class_name(p.getObject_class_name());
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        session.close();
    }
    public void delete(ObjectClass p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(ObjectClass.class, p.getObject_class_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }
    public ObjectClass read(ObjectClass p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (ObjectClass) session.load(ObjectClass.class, p.getObject_class_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<ObjectClass> list() {
        Session session = this.sessionFactory.openSession();
        List<ObjectClass> objectClassList = session.createQuery("from ObjectClass").list();
        session.close();
        return objectClassList;
    }

}