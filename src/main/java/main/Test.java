package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.coords.Coords;
import service.galaxies.Galaxies;
import service.galaxies.Galaxies_DAO;
import service.stars.Stars_DAO;

import java.util.List;
import java.util.Random;

/**
 * Created by 12 on 28.10.2017.
 */
public class Test {
    private static Galaxies randomGalaxy(Integer id){
        Random r=new Random();
        Galaxies g=new Galaxies();
        g.setObject_id(id);
        g.setGalaxy_coordinates(new Coords(r.nextFloat(),r.nextFloat()));
        return g;
    }
    public static boolean testUpdate(Integer id){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Galaxies_DAO galaxyDao=context.getBean(Galaxies_DAO.class);
        Galaxies g=randomGalaxy(id);
        Galaxies oldG=g;
        galaxyDao.update(g);
        galaxyDao.read(oldG);
        context.close();
        return g.getCoords()==oldG.getCoords()&&g.getObject_id()==g.getObject_id();
    }
}
