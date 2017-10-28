package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.galaxies.Galaxies;
import service.galaxies.Galaxies_DAO;
import service.stars.Stars_DAO;

import java.util.List;

/**
 * Created by 12 on 28.10.2017.
 */
public class Test {
    public static boolean test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Galaxies_DAO galaxyDao=context.getBean(Galaxies_DAO.class);
        List<Galaxies> l=galaxyDao.list();
        for(Galaxies g:l)
            System.out.println(g);







        context.close();
        return true;

    }
}
