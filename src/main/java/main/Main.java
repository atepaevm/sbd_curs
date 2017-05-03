package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.*;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //Objects_Classes_Rep_Impl impl=new Objects_Classes_Rep_Impl();
       // Objects_Classes obj=impl.find(1);

       Objects_Classes_DAO dao = context.getBean(Objects_Classes_DAO.class);

        List<Objects_Classes> list = dao.list();
        for(Objects_Classes p : list){
            System.out.println("Person List::"+p);
        }

        //close resources
        context.close();
    }
}