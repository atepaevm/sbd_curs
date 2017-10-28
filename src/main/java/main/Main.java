package main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.coords.Coords;
import service.galaxies.Galaxies;
import service.objectClass.ObjectClass;
import service.objectClass.ObjectClassDAO;
import service.galaxies.Galaxies_DAO;
import service.objectCommon.ObjectCommon;
import service.objectCommon.ObjectCommonDAO;
import service.objectType.ObjectType;
import service.objectType.ObjectTypeDAO;
import service.rolling_objects.Rolling_Objects;
import service.rolling_objects.Rolling_Objects_DAO;
import service.stars.Stars;
import service.stars.Stars_DAO;
import view.ObjectTypeView;
import view.StarView;

public class Main {

    public static void printObjectType(ObjectType type, ObjectClassDAO objDao){
        ObjectClass objectClass = objDao.findOne(type.getObject_class_id());
        ObjectTypeView view = new ObjectTypeView(objectClass, type);
        System.out.println(view);
    }

    public static void printStar(ObjectCommon objectCommon, Stars_DAO starsDao){
        Stars star = starsDao.findOne(objectCommon.getObject_id());
        StarView view = new StarView(star, objectCommon);
        System.out.println(view);
    }

    public static Galaxies createNewGalaxy(Galaxies_DAO galaxiesDao, Integer type, String name, Coords coords){
        ObjectCommon objectCommon = new ObjectCommon(name, type);
        Galaxies galaxy = new Galaxies(coords);
        galaxiesDao.save(objectCommon, galaxy);
        return galaxy;
    }

    public static Rolling_Objects createNewRollingObject(Rolling_Objects_DAO rollingObjectsDao, String name, Integer type, Integer orbitsAround){
        ObjectCommon objectCommon = new ObjectCommon(name, type);
        Rolling_Objects rollingObject;
        if(orbitsAround != null){
            rollingObject = new Rolling_Objects(orbitsAround);
        } else {
            rollingObject = new Rolling_Objects();
        }
        rollingObjectsDao.save(objectCommon, rollingObject);
        return rollingObject;
    }

    public static Stars createNewStar(Stars_DAO starsDao, String name, Integer type, Integer galaxyId, Coords starCoords, Float distFromSun, Float size, Float mass){
        ObjectCommon objectCommon = new ObjectCommon(name, type);
        Stars star = new Stars(galaxyId, starCoords, size, mass, distFromSun);
        starsDao.save(objectCommon, star);
        return star;
    }

    public static void printList(List list){
        for(Object o: list){
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Stars_DAO starsDao = context.getBean(Stars_DAO.class);
        Galaxies_DAO galaxyDao=context.getBean(Galaxies_DAO.class);
        ObjectClassDAO obj_dao=context.getBean(ObjectClassDAO.class);
        Rolling_Objects_DAO roll_dao=context.getBean(Rolling_Objects_DAO.class);
        ObjectTypeDAO types_dao=context.getBean(ObjectTypeDAO.class);
        ObjectCommonDAO objCommon = context.getBean(ObjectCommonDAO.class);
        */
        //Test test=new Test();

        /*
        List<ObjectCommon> list = objCommon.list();
        for(ObjectCommon p : list){
            System.out.println(p);
        }*/

        /*List<ObjectType> list = types_dao.list();
        List<ObjectType> list = types_dao.list();
        for(ObjectType p : list){
            printObjectType(p, obj_dao);
        }*/


        /*
        List<Galaxies> list = galaxyDao.list();
        printList(list);
        Galaxies g = list.get(0);
        g.setGalaxy_coordinates(new Coords(2.5f,2.5f));
        galaxyDao.update(g);
        printList(list);
        */

        /*
        List<Galaxies> list = galaxyDao.list();
        printList(list);
        galaxyDao.delete(list.get(3));
        list = galaxyDao.list();
        printList(list);
        */

        /*
        Stars star = createNewStar(starsDao, "Звезда", 7, 17, new CoordsEmbedded(0.5f, 2.5f), 2.0f, 2f, 1.4f);
        System.out.println(star);
        */

        //printStar(objCommon.findOne(4), starsDao);


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
        //context.close();
    }
}