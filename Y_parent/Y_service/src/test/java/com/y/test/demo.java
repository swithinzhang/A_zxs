package com.y.test;

import com.y.entity.*;
import com.y.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class demo {

//成功
    @Test
    public void test1(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        UserService us = (UserService) ac.getBean("userService");
        // 调用方法
        us.Register("asdasda@", "asdasdas");

//        user user = us.Login("111@111", "wwre");
//        if (user!=null){
//            System.out.println("登录成功");
//        }else {
//            System.out.println("登录失败");
//        }
    }

    @Test
    public void test2(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        UserService us = (UserService) ac.getBean("userService");
        // 调用方法
        user user = us.validatemail("asdasda@");

        System.out.println(user);
    }

    @Test
    public void test3(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        CourseService cs = (CourseService) ac.getBean("courseService");
        // 调用方法
//        List<course> list = cs.findAllCourse();
        List<String> list = cs.findAllCourseName();

        for (String s : list){
            System.out.println(s);
        }
    }

    @Test
    public void test4(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        UserService us = (UserService) ac.getBean("userService");
        // 调用方法
        us.updateUser(29,"哈哈哈","122121");

        user user = us.validatemail("asdasda1@");
        System.out.println(user);
    }
    @Test
    public void test5(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        SubjectService ss = (SubjectService) ac.getBean("subjectService");
        // 调用方法
        List<subject> allSubject = ss.findAllSubject();
        for (subject s:allSubject){
            System.out.println(s);
        }
    }

    @Test
    public void test6(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        UserService us = (UserService) ac.getBean("userService");
        // 调用方法
         us.totalUpdateUser(9,"哈哈","man","1999-01-01","加利福尼亚");
    }

    @Test
    public void test7(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        UserService us = (UserService) ac.getBean("userService");
        // 调用方法
        us.imgUpdateUser(10,"2.png");
    }

    @Test
    public void test8(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        AdminService us = (AdminService) ac.getBean("adminService");
        // 调用方法
        admin laoyan = us.adminLogin("laoyan", "123456");
        if (laoyan!=null&&!laoyan.equals("")){
            boolean b = true;
            System.out.println(b);
        }
    }
    @Test
    public void test9(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        VideoService vs = (VideoService) ac.getBean("videoService");
        // 调用方法
//        List<video> allVideo = vs.findAllVideo();
//        for (video v:allVideo){
//            System.out.println(v);
//        }
        List<video> allVideoAndSpeaker = vs.findAllVideoAndSpeaker();
        for (video v : allVideoAndSpeaker){
            System.out.println(v);
        }
    }
    @Test
    public void test10(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        VideoService vs = (VideoService) ac.getBean("videoService");
        // 调用方法
        vs.insertVideo("1","1",1,1231,1233,"1","1");
    }

    @Test
    public void test11(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        CourseService cs = (CourseService) ac.getBean("courseService");
        // 调用方法
        List<course> courseList = cs.findAll();
        for (course c: courseList){
            System.out.println(c);
        }
    }

    @Test
    public void test12(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        CourseService cs = (CourseService) ac.getBean("courseService");
        // 调用方法
        cs.InsertCourse("1","1","1");
    }

    @Test
    public void test13(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        CourseService cs = (CourseService) ac.getBean("courseService");
        // 调用方法
        course byId = cs.findById(6);
        System.out.println(byId);
    }

    @Test
    public void test14(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        VideoService vs = (VideoService) ac.getBean("videoService");
        // 调用方法
//        List<video> videos = vs.SelectSql("%H%", 9);
//        for (video v : videos){
//            System.out.println(v);
//        }

        vs.SelectSqlcc("");
    }
}
