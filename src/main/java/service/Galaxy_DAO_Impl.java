package service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class Galaxy_DAO_Impl implements Galaxy_DAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Integer> save(Galaxy obj) {
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
}
