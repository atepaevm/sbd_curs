package service.galaxies;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.objectCommon.ObjectCommon;
import service.stars.Stars;

import java.util.List;

public class Galaxies_DAO_Impl implements Galaxies_DAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(ObjectCommon objectCommon, Galaxies galaxy) {
        Session session = this.sessionFactory.openSession();
        Integer res = (Integer)session.createSQLQuery("SELECT * FROM galaxy_insert(:type, :name, (:long, :lat))")
                .setParameter("type",objectCommon.getType_id())
                .setParameter("name", objectCommon.getObject_name())
                .setParameter("long", galaxy.getCoords().getLongtitude())
                .setParameter("lat", galaxy.getCoords().getLatitude())
                .list().get(0);
        galaxy.setObject_id(res);
        objectCommon.setObject_id(res);
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
        session.createSQLQuery("SELECT delete_galaxy(:id);")
                .setParameter("id", obj.getObject_id()).list();
        session.close();
    }

    public Galaxies read(Galaxies obj) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        return (Galaxies) session.load(Galaxies.class, obj.getObject_id());
    }
    public List<Galaxies> list() {
        Session session = this.sessionFactory.openSession();
        List<Galaxies> list = session.createQuery("from Galaxies ORDER BY object_id").list();
        session.close();
        return list;
    }
}
