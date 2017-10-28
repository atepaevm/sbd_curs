package service.galaxies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.stars.Stars;

import java.util.List;

public class Galaxies_DAO_Impl implements Galaxies_DAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
/*
    public List<Integer> save(Galaxies obj) {
        Session session = this.sessionFactory.openSession();
        List<Integer> res = session.createSQLQuery("SELECT * FROM galaxy_insert(:id, :name, (:long, :lat))")
                .setParameter("id", obj.getTypeId())
                .setParameter("name", obj.getName())
                .setParameter("long", obj.getCoords().getLongtitude())
                .setParameter("lat", obj.getCoords().getLatitude())
                .list();
        session.close();
        return res;
    }
*/

    public void save(Galaxies p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createSQLQuery("INSERT INTO galaxies (object_id, galaxy_coordinates" +
                "VALUES ("+p.getObject_id()+","+p.getCoords().toDBString()+";").executeUpdate();
        tx.commit();
        session.close();
    }

    public void update(Galaxies p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String query="UPDATE galaxies set object_id=" +p.getObject_id()+", galaxy_coordinates=("+p.getCoords()+
                ") WHERE object_id="+p.getObject_id()+";";
        session.createSQLQuery(query).executeUpdate();
        tx.commit();
        sessionFactory.close();
    }

    public void delete(Galaxies obj) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(Galaxies.class, obj.getObject_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
        tx.commit();
        session.close();
    }

    public Galaxies read(Galaxies obj) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Galaxies) session.load(Galaxies.class, obj.getObject_id());
    }
    public List<Galaxies> list() {
        Session session = this.sessionFactory.openSession();
        List<Galaxies> list = session.createQuery("from Galaxies").list();
        session.close();
        return list;
    }
}
