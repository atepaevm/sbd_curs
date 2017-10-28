package main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Objects_Classes.Objects_Classes_DAO;
import service.coords.Coords;
import service.galaxies.Galaxies;
import service.galaxies.Galaxies_DAO;
import service.objects_types.Objects_Types_DAO;
import service.objects_types.Objects_types;
import service.rolling_objects.Rolling_Objects;
import service.rolling_objects.Rolling_Objects_DAO;
import service.stars.Stars_DAO;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Stars_DAO starsDao = context.getBean(Stars_DAO.class);
        Galaxies_DAO galaxyDao=context.getBean(Galaxies_DAO.class);
        Objects_Classes_DAO obj_dao=context.getBean(Objects_Classes_DAO.class);
        Rolling_Objects_DAO roll_dao=context.getBean(Rolling_Objects_DAO.class);
        Objects_Types_DAO types_dao=context.getBean(Objects_Types_DAO.class);
        List<Objects_types> list =types_dao.list();
        //Galaxies g=galaxyDao.read(list.get(0));
        //g.setGalaxy_coordinates(new Coords(new Float(1),new Float(1)));
        //galaxyDao.update(g);
        //list =galaxyDao.list();
        for(Objects_types p : list){
            System.out.println(p);
        }
        /*
        System.out.println("saving:");
        Stars star=new Stars();
        star.setObject_id(4);
        star.setGalaxy_id(1);
        star.setStar_coodinates(new Coords(new Float(1),new Float(1)));
        star.setStar_mass(new Float(123));
        star.setStar_size(new Float(123));
        star.setStar_mass(new Float(123));
        star.setStar_distnace_from_sun(new Float(123));
        starsDao.update(star);
        for(Stars p : list){
            System.out.println(p);
        }
        */
        context.close();
    }
}