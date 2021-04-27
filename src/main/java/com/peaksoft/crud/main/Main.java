package com.peaksoft.crud.main;

import com.peaksoft.crud.config.DBConfig;
import com.peaksoft.crud.dao.UserDao;
import com.peaksoft.crud.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DBConfig.class);

        UserDao userDao = context.getBean(UserDao.class);

        User user1 = new User();
        User user2 = new User();
//        userDao.addUser(user1);
//        userDao.addUser(user2);

        userDao.deleteUser(user1);

        List<User>list = userDao.getAllUsers();
        for (User user : list) {
            System.out.println("id " + user.getId());
            System.out.println("name " + user.getName());
            System.out.println("age " + user.getAge());
        }


    }
}
