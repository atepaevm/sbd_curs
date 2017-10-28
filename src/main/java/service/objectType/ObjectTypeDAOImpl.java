package service.objectType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.objectClass.ObjectClass;

import java.util.List;


public class ObjectTypeDAOImpl implements ObjectTypeDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void save(ObjectType p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
    public void update(ObjectType p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        ObjectType emp = (ObjectType) session.load(ObjectType.class, p.getObject_type_id());
        emp=p;
       // emp.setObject_class_name(p.getObject_class_name());
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        sessionFactory.close();
    }
    public void delete(ObjectType p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(ObjectType.class, p.getObject_type_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }

    public ObjectType read(ObjectType obj) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (ObjectType) session.load(ObjectType.class, obj.getObject_type_id());
    }

    public ObjectClass read(ObjectClass p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (ObjectClass) session.load(ObjectClass.class, p.getObject_class_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<ObjectType> list() {
        Session session = this.sessionFactory.openSession();
        List<ObjectType> Objects_ClassesList = session.createQuery("from ObjectType").list();
        session.close();
        return Objects_ClassesList;
    }

}