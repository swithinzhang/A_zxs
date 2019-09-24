package com.y.controller;

import com.y.entity.admin;
import com.y.entity.course;
import com.y.entity.speaker;
import com.y.entity.video;
import com.y.service.speakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    speakerService speakerService;

    public void setSpeakerService(com.y.service.speakerService speakerService) {
        this.speakerService = speakerService;
    }

    @RequestMapping("/showSpeakerList")
    public String showSpeakerList(HttpServletRequest request) throws IOException {
        System.out.println("进来了主讲人管理页面");
        List<speaker> speakerList = speakerService.findAllSpeaker();
        request.getSession().setAttribute("speakerList",speakerList);

        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/speakerList.jsp";
        return viewname;
    }

    @RequestMapping("/addSpeakera")
    public String addSpeakerat(HttpServletRequest request) throws IOException {
        System.out.println("进来了主讲人添加页面");
        request.getSession().removeAttribute("speaker");
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addSpeaker.jsp";
        return viewname;
    }

    @RequestMapping("/updateSpeaker")
    public String updateSpeaker(Integer id,HttpServletRequest request) throws IOException {
        System.out.println("进来了updateVideo");
        speaker speaker = speakerService.findById(id);
        request.getSession().setAttribute("speaker",speaker);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addSpeaker.jsp";
        return viewname;
    }

    @RequestMapping("/saveOrUpdateSpeaker")
    public String saveOrUpdateSpeaker(HttpServletRequest request) throws IOException {
        System.out.println("进来了saveOrUpdateSpeaker");
        String a = null;
        a = request.getParameter("idSpeaker");
        String spname = request.getParameter("spname");
        String spjob = request.getParameter("spjob");
        String spdesc = request.getParameter("spdesc");
        if (a==null) {
            System.out.println("开始进行添加");
            speakerService.insertSpeaker(spname,spdesc,spjob);
            request.getSession().setAttribute("speakerMessage","添加成功");
            String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addSpeaker.jsp";
            return viewname;
        }else if (a!=null){
            System.out.println("开始进行修改");
            int id = Integer.parseInt(a);
            speakerService.updateSpeaker(id,spname,spdesc,spjob);
            request.getSession().setAttribute("speakerMessage","修改成功");
            request.getSession().removeAttribute("speaker");
            String viewname = "redirect:http://localhost:8080/Y_web/jsp/behind/addSpeaker.jsp";
            return viewname;
        }
        return null;
    }

    @RequestMapping("/speakerDel")
    public @ResponseBody
    String speakerDel(Integer id, HttpServletRequest request) throws IOException {
        System.out.println("进来了删除主讲人");
        speakerService.deleteSpeaker(id);
        return "success";
    }
}
