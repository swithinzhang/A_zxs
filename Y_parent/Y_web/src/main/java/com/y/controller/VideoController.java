package com.y.controller;

import com.y.entity.course;
import com.y.entity.speaker;
import com.y.entity.user;
import com.y.entity.video;
import com.y.service.CourseService;
import com.y.service.VideoService;
import com.y.service.speakerService;
import com.y.utils.NavigationTag;
import com.y.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("video")
public class VideoController {
    @Autowired
    CourseService courseService;

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

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

    @RequestMapping("/list")
    public String videolist(HttpServletRequest request) throws IOException {
        //test
        //System.out.println("videolist");

        //获取列表
        List<video> allVideoAndSpeaker = videoService.findAllVideoAndSpeaker();
        List<speaker> allSpeaker = speakerService.findAllSpeaker();
        List<course> allCourse = courseService.findAllCourse();

        Page<video> objectPage = new Page<>();
        objectPage.setTotal(allVideoAndSpeaker.size());
        objectPage.setPage(1);
        objectPage.setSize(10);
        objectPage.setRows(allVideoAndSpeaker);


        //存域对象
        request.getSession().setAttribute("page",objectPage);
        request.getSession().setAttribute("courseList",allCourse);
        request.getSession().setAttribute("speakerList",allSpeaker);
        request.getSession().setAttribute("video",allVideoAndSpeaker);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/videoList.jsp";
        return viewname;
    }

    @RequestMapping("/selectlist")
    public String videoSelectList(HttpServletRequest request) throws IOException {
        System.out.println("videoSelectList");
        String title = "";
        String t = request.getParameter("title");
        String speakerName = request.getParameter("selectSpeakerName");
        String courseTitle = request.getParameter("selectCourseTitle");

        String id = request.getParameter("speakerId");
        String cid = request.getParameter("courseId");
        System.out.println("id:"+id+"cid:"+cid);
        if (t==null&&t.equals("")&&t.equals("标题")){
            System.out.println("模糊查询为空了");
            if (id!=null){
                System.out.println("讲师不为空");
                List<video> videos = videoService.SelectSql(title, Integer.valueOf(id));
                request.getSession().setAttribute("video",videos);
            }else if (courseTitle!=null){
                System.out.println("讲师为空但课不为空");
                List<video> videos = videoService.SelectSqlc(title, Integer.valueOf(cid));
                request.getSession().setAttribute("video",videos);
            }else {
                System.out.println("讲师课都为空");
                List<video> videos = videoService.findAllVideoAndSpeaker();
                request.getSession().setAttribute("video",videos);
            }
        }else {
            System.out.println("模糊查询不为空");
            if (id!=null){
                System.out.println("讲师不为空");
                title = "%"+t+"%";
                List<video> videos = videoService.SelectSql(title, Integer.valueOf(id));
                request.getSession().setAttribute("video",videos);
            }else if (cid!=null){
                System.out.println("讲师为空但课不为空");
                title = "%"+t+"%";
                List<video> videos = videoService.SelectSqlc(title, Integer.valueOf(cid));
                request.getSession().setAttribute("video",videos);
            }else {
                System.out.println("讲师课都为空");
                title = "%"+t+"%";
                List<video> videos = videoService.SelectSqlcc(title);
                request.getSession().setAttribute("video",videos);
            }
        }
        List<speaker> allSpeaker = speakerService.findAllSpeaker();
        List<course> allCourse = courseService.findAllCourse();
        request.getSession().setAttribute("courseList",allCourse);
        request.getSession().setAttribute("speakerList",allSpeaker);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/videoList.jsp";
        return viewname;
    }


    @RequestMapping("/addVideo")
    public String videoAddVideo(HttpServletRequest request) throws IOException {
        System.out.println("进来了addVideo");
//        List<video> video = videoService.findAllVideo();
        List<speaker> speakerList = speakerService.findAllSpeaker();
        List<course> courseList = courseService.findAllCourse();

//        request.getSession().setAttribute("video",video);
        request.getSession().setAttribute("speakerList",speakerList);
        request.getSession().setAttribute("courseList",courseList);
        request.getSession().removeAttribute("video");
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addVideo.jsp";
        return viewname;
    }
    @RequestMapping("/updateVideo")
    public String videoApdateVideo(String id,HttpServletRequest request) throws IOException {
        System.out.println("进来了updateVideo");
        video video = videoService.findById(id);
        List<speaker> speakerList = speakerService.findAllSpeaker();
        List<course> courseList = courseService.findAllCourse();


        request.getSession().setAttribute("video",video);
        request.getSession().setAttribute("speakerList",speakerList);
        request.getSession().setAttribute("courseList",courseList);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addVideo.jsp";
        return viewname;
    }

    @RequestMapping("/saveOrUpdate")
    public String videoSaveOrUpdate(HttpServletRequest request) throws IOException {
        System.out.println("进来了saveOrUpdate");
        String a = null;
        a = request.getParameter("id");
        //所需要的数据为int,此处需要强转
        String spearkerId = request.getParameter("spearkerId");
        String courseId = request.getParameter("courseId");
        String t = request.getParameter("time");
        //下面是添加所需要的数据
        //使用Integer.parseInt（String str）方法进行转换
        int spearker_id = Integer.parseInt(spearkerId);
        int course_id = Integer.parseInt(courseId);
        int time = Integer.parseInt(t);
        String title = request.getParameter("title");
        String image_url = request.getParameter("imageUrl");
        String video_url = request.getParameter("videoUrl");
        String detail = request.getParameter("detail");
        if (a==null) {
            System.out.println("开始进行添加");
            videoService.insertVideo(title,detail,time,spearker_id,course_id,video_url,image_url);
            request.getSession().setAttribute("videomessage","添加成功");
            String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addVideo.jsp";
            return viewname;
        }else if (a!=null){
            System.out.println("开始进行修改");
            int id = Integer.parseInt(a);
            videoService.updateVideo(id,title,detail,time,spearker_id,course_id,video_url,image_url);
            request.getSession().setAttribute("videomessage","修改成功");
            request.getSession().removeAttribute("video");
            String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addVideo.jsp";
            return viewname;
        }
        return null;
    }

    @RequestMapping("/videoDel")
    public @ResponseBody
    String videoDel(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("videoDel");
        videoService.delVideo(id);
        return "success";
    }

    @RequestMapping("/delBatchVideos")
    public void delBatchVideos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("delBatchVideos");
        String[] ids = request.getParameterValues("ids");
        for (String id : ids){
            videoService.delVideo(Integer.valueOf(id));
        }
        response.sendRedirect(request.getContextPath()+"/video/list");
//        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/videoList.jsp";
//        return viewname;
    }
}
