package service.stars;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.objectCommon.ObjectCommon;

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
    public void save(ObjectCommon objectCommon, Stars star){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Integer id = (Integer) session.save(objectCommon);
        if(id == null){
            tx.rollback();
            session.close();
            return;
        }
        objectCommon.setObject_id(id);
        star.setObject_id(id);
        session.save(star);
        tx.commit();
        session.close();
    }
    public void update(Stars p){

        // Prep Work
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        /*
        String query="UPDATE stars set galaxy_id=" +p.getGalaxy_id()+", star_coordinates=ROW("+p.getStar_coodinates().getLatitude()+
                ", "+p.getStar_coodinates().getLongtitude()+
                "), star_distance_from_sun"+p.getStar_distnace_from_sun()+", star_mass="+p.getStar_mass()+", star_size="+p.getStar_size()+
                "WHERE object_id="+p.getObject_id();
                */
        String query="UPDATE stars set galaxy_id=" +p.getGalaxy_id()+", star_distance_from_sun="+p.getStar_distnace_from_sun()+", star_mass="+p.getStar_mass()+", star_size="+p.getStar_size()+
                " WHERE object_id="+p.getObject_id()+";";
        session.createSQLQuery(query).executeUpdate();
        tx.commit();
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
