package service.objectCommon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ObjectCommonDAOImpl implements ObjectCommonDAO {

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void update(ObjectCommon obj) {

    }

    public void delete(ObjectCommon obj) {

    }

    public ObjectCommon findOne(Integer id) {
        Session session = this.sessionFactory.openSession();
        ObjectCommon retVal = (ObjectCommon)session.createQuery("From ObjectCommon WHERE object_id = :id")
                .setParameter("id", id).list().get(0);

        session.close();
        return retVal;
    }

    public ObjectCommon read(ObjectCommon obj) {
        return null;
    }

    public List<ObjectCommon> list() {
        Session session = this.sessionFactory.openSession();
        List<ObjectCommon> list = session.createQuery("from ObjectCommon").list();
        session.close();
        return list;
    }
/*
    //@Override
    public void save(ObjectCommon p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
    public void update(ObjectCommon p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        ObjectCommon emp = (ObjectCommon) session.load(ObjectCommon.class, p.getObject_id());
        emp.setObject_class_name(p.getObject_class_name());
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        sessionFactory.close();

    }
    public void delete(ObjectCommon p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(ObjectCommon.class, p.getObject_class_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }
    public ObjectCommon read(ObjectCommon p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (ObjectCommon) session.load(ObjectCommon.class, p.getObject_class_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<ObjectCommon> list() {
        Session session = this.sessionFactory.openSession();
        List<ObjectCommon> Objects_ClassesList = session.createQuery("from objectClass").list();
        session.close();
        return Objects_ClassesList;
    }
*/
}
