package main;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.coords.Coords;
import service.galaxies.Galaxies;
import service.galaxies.Galaxies_DAO;
import service.objectCommon.ObjectCommon;

import java.util.Random;

/**
 * Created by 12 on 28.10.2017.
 */
public class Test {

    private static Galaxies_DAO galaxyDao;

    private static Galaxies randomGalaxy(Integer id){
        Random r=new Random();
        Galaxies g=new Galaxies();
        g.setObject_id(id);
        g.setGalaxy_coordinates(new Coords(r.nextFloat(),r.nextFloat()));
        return g;
    }

    private static Integer testInsert(String name, Integer objectType, Coords galaxyCoords){
        ObjectCommon objectCommon = new ObjectCommon(name, objectType);
        Galaxies galaxy = new Galaxies(galaxyCoords);
        galaxyDao.save(objectCommon, galaxy);

        Galaxies gal = new Galaxies();
        gal.setObject_id(galaxy.getObject_id());
        gal = galaxyDao.read(gal);

        return (galaxy.getObject_id() != null && gal.getCoords().equals(galaxy.getCoords())) ? galaxy.getObject_id() : null;
    }


    public static boolean testUpdate(Integer id){
        Galaxies g=randomGalaxy(id);
        Galaxies oldG=g;
        galaxyDao.update(g);
        galaxyDao.read(oldG);
        return g.getCoords()==oldG.getCoords()&&g.getObject_id()==g.getObject_id();
    }

    public static boolean test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        galaxyDao = context.getBean(Galaxies_DAO.class);
        Integer galaxyId = testInsert("Что-то", 4, new Coords(0.5f, 0.5f));
        if(galaxyId != null){
            Boolean upd, del;
            upd = testUpdate(galaxyId);
            if(! upd){
                System.err.println("Update failed");
            }
            del = testDelete(galaxyId);
            if(!del){
                System.err.println("Delete failed");
            }
            context.close();
            return upd && del;
        }
        System.err.println("Insert failed");
        context.close();
        return false;
    }
    public static boolean testDelete(Integer id){
        Galaxies g=galaxyDao.read(randomGalaxy(id));
        Integer oldId=g.getObject_id();
        galaxyDao.delete(g);
        g.setObject_id(oldId);
        try {
            Galaxies newG=galaxyDao.read(g);
            System.out.println(newG);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
