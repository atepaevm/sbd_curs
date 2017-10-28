package service.rolling_objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.objectCommon.ObjectCommon;

import java.util.List;


public class Rolling_Objects_DAO_Impl implements Rolling_Objects_DAO {

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Override
    public void save(ObjectCommon objectCommon, Rolling_Objects rolling_object) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Integer id = (Integer) session.save(objectCommon);
        if(id == null){
            tx.rollback();
            session.close();
            return;
        }
        objectCommon.setObject_id(id);
        rolling_object.setObject_id(id);
        session.save(rolling_object);
        session.flush();
        tx.commit();
        session.close();
    }
    public void update(Rolling_Objects p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Rolling_Objects emp = (Rolling_Objects) session.load(Rolling_Objects.class, p.getObject_id());
        emp=p;
        tx.commit();

        // update example

        //tx = session.beginTransaction();
        //session.update(emp);
        //tx.commit();
        sessionFactory.close();
    }
    public void delete(Rolling_Objects p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Rolling_Objects.class, p.getObject_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }
    public Rolling_Objects read(Rolling_Objects p){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Rolling_Objects) session.load(Rolling_Objects.class, p.getObject_id());
    }
    @SuppressWarnings("unchecked")
    //@Override
    public List<Rolling_Objects> list() {
        Session session = this.sessionFactory.openSession();
        List<Rolling_Objects> Objects_ClassesList = session.createQuery("from service.rolling_objects.Rolling_Objects").list();
        session.close();
        return Objects_ClassesList;
    }

}