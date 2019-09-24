package com.y.controller;

import com.y.entity.course;
import com.y.entity.speaker;
import com.y.entity.subject;
import com.y.entity.video;
import com.y.service.CourseService;
import com.y.service.SubjectService;
import com.y.service.VideoService;
import com.y.service.speakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    speakerService speakerService;

    public void setSpeakerService(com.y.service.speakerService speakerService) {
        this.speakerService = speakerService;
    }

    @Autowired
    VideoService videoService;

    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Autowired
    SubjectService subjectService;

    @Autowired
    CourseService courseService;

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("index");
        List<String> courseName = courseService.findAllCourseName();
        request.getSession().setAttribute("courseName",courseName);
        String viewname = "redirect:http://localhost:8080/Y_web/index.jsp";
        return viewname;
    }

    @RequestMapping("/findCourse")
    public String findCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("findCourse");
        List<subject> allSubject = subjectService.findAllSubject();
        List<course> allCourse = courseService.findAllCourse();
        List<video> allVideo = videoService.findAllVideo();
        request.getSession().setAttribute("video",allVideo);
        request.getSession().setAttribute("subject",allSubject);
        request.getSession().setAttribute("course",allCourse);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/course.jsp";
        return viewname;
    }

    @RequestMapping("/littleTemple")
    public String littleTemple(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("littleTemple");
        List<speaker> allSpeaker = speakerService.findAllSpeaker();
        request.getSession().setAttribute("speaker",allSpeaker);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/section.jsp";
        return viewname;
    }

    @RequestMapping("/showCourseList")
    public String showCourseList(HttpServletRequest request) throws IOException {
        System.out.println("showCourseList");
        List<course> courseList = courseService.findAll();
        request.getSession().setAttribute("courseList",courseList);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/courseList.jsp";
        return viewname;
    }

    @RequestMapping("/addCourse")
    public String addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("addCourse");
        request.getSession().removeAttribute("course");
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addCourse.jsp";
        return viewname;
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(Integer id,HttpServletRequest request) throws IOException {
        System.out.println("updateCourse");
        course course = courseService.findById(id);
        request.getSession().removeAttribute("course");
        System.out.println(course);
        request.getSession().setAttribute("course",course);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addSpeaker.jsp";
        return viewname;
    }

    @RequestMapping("/saveOrUpdateCourse")
    public String saveOrUpdateCourse(HttpServletRequest request) throws IOException {
        System.out.println("saveOrUpdateCourse");
        String a = null;
        a = request.getParameter("idCourse");
        String ctitle = request.getParameter("ctitle");
        String cdesc = request.getParameter("cdesc");
        String cid = request.getParameter("cid");
        if (a==null) {
            System.out.println("开始进行添加课程");
            courseService.InsertCourse(ctitle,cdesc,cid);
            request.getSession().setAttribute("CourseMessage","添加成功");
            String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addSpeaker.jsp";
            return viewname;
        }else if (a!=null){
            System.out.println("开始进行修改");
            int id = Integer.parseInt(a);
            courseService.updateCourse(id,ctitle,cdesc,cid);
            request.getSession().setAttribute("CourseMessage","修改成功");
            request.getSession().removeAttribute("course");
            String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addSpeaker.jsp";
            return viewname;
        }
        return null;
    }

    @RequestMapping("/courseDel")
    public @ResponseBody
    String speakerDel(Integer id, HttpServletRequest request) throws IOException {
        System.out.println("进来了删除课程");
       courseService.deleteCourse(id);
        return "success";
    }
}
