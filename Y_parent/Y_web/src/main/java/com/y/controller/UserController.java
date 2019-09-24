package com.y.controller;

import com.y.entity.user;
import com.y.service.UserService;
import com.y.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/userLogin")
    public @ResponseBody String userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("进来了userLogin");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        user u = userService.Login(email, password);
        System.out.println(email+"--"+password);
        if (u!=null){
            request.getSession().setAttribute("emailName",email);
            System.out.println("登录成功");
            return "success";
        }else {
            request.getSession().setAttribute("data","账号或密码错误，请重新登录");
            String viewname = "redirect:http://localhost:8080/Y_web/index.jsp";
            return "viewname";
        }
    }

    @RequestMapping("/insertUser")
    public @ResponseBody String userRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("userRegist");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        System.out.println(email+"--"+password);
        if (email!=null&&password!=null){
            userService.Register(email,password);
            System.out.println("注册成功");
            return "success";
        }else {
            return "邮箱或密码不能为空！";
        }
    }

    @RequestMapping("/validatemail")
    public @ResponseBody String uservalidatemail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("validatemail");
        String email = request.getParameter("email");
        user user = null;
         user = userService.validatemail(email);
        if (user==null){
            System.out.println("名字可用");
            return "success";
        }else {
            return "邮箱名已被占用";
        }
    }

    @RequestMapping("/apply")
    public  String userApply(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("apply");
        String emailName =(String) request.getSession().getAttribute("emailName");
//        System.out.println("emailName"+emailName);
        user user = userService.validatemail(emailName);
        Integer id = user.getId();
//        System.out.println(user);
        String nickName = request.getParameter("name");
        String tel = request.getParameter("tel");
        String qq = request.getParameter("qq");
        String phoneNum ="电话"+tel+"QQ:"+qq;
//        System.out.println("nickName"+nickName);
//        System.out.println("tel"+tel);
//        System.out.println("qq"+qq);
        userService.updateUser(id,nickName,phoneNum);
        request.getSession().setAttribute("message","报名成功！");
        String viewname = "redirect:http://localhost:8080/Y_web/index.jsp";
        return viewname;
    }


    @RequestMapping("/loginOut")
    public String userloginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("userAccount");
        String viewname = "redirect:http://localhost:8080/Y_web/index.jsp";
        return viewname;
    }

    @RequestMapping("/showMyProfile")
    public String usershowMyProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String s = (String)request.getSession().getAttribute("emailName");
        user user = userService.validatemail(s);
        System.out.println(user);
        request.getSession().setAttribute("user",user);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/my_profile.jsp";
        return viewname;
    }
    @RequestMapping("/updateUser")
    public String userupdateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = null;
        String nickname = null;
        String sex = null;
        String birthday = null;
        String email = null;
        String address = null;
        id = Integer.valueOf(request.getParameter("id"));
        nickname = request.getParameter("nickname");
        sex = request.getParameter("sex");
        birthday = request.getParameter("birthday");
        email = request.getParameter("email");
        address =   request.getParameter("address");
        userService.totalUpdateUser(id,nickname,sex,birthday,address);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/my_profile.jsp";
        return viewname;
    }


    @RequestMapping("/changeProfile")
    public String userchangeProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String s = (String)request.getSession().getAttribute("emailName");
        user user = userService.validatemail(s);
        System.out.println(user);
        request.getSession().setAttribute("user",user);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/change_profile.jsp";
        return viewname;
    }

    @RequestMapping("/changeAvatar")
    public String userchangeAvatar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String s = (String)request.getSession().getAttribute("emailName");
        user user = userService.validatemail(s);
        System.out.println(user);
        request.getSession().setAttribute("user",user);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/change_avatar.jsp";
        return viewname;
    }

    @RequestMapping("/upLoadImage")
    public String userupLoadImage(MultipartFile image_file,HttpServletRequest request) throws Exception {
        System.out.println("进来了上传图片页面");
        //获取到登录时的用户名，提供给查询用户用
        String s = (String)request.getSession().getAttribute("emailName");
        //上传文件
        String path = "C:\\apache-tomcat\\webapps\\Show"+"/";
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        String filename = image_file.getOriginalFilename();
        image_file.transferTo(new File(path,filename));
        //查到用户以后，获取用户的ID
        user user = userService.validatemail(s);
        String imgUrl = filename;
        //执行更改头像操作
        userService.imgUpdateUser(user.getId(),imgUrl);
//        System.out.println(user);
        com.y.entity.user user1 = userService.validatemail(s);
        request.getSession().setAttribute("user",user1);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/change_avatar.jsp";
        return viewname;
    }

    @RequestMapping("/passwordSafe")
    public String userpasswordSafe(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String s = (String)request.getSession().getAttribute("emailName");
        user user = userService.validatemail(s);
//        System.out.println(user);
        request.getSession().setAttribute("user",user);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/password_safe.jsp";
        return viewname;
    }

    @RequestMapping("/updatePassword")
    public String userupdatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("进来了修改密码页面");
        //获取当前用户信息
        String s = (String)request.getSession().getAttribute("emailName");
        user user = userService.validatemail(s);
        //获取前台页面要修改的密码
        String newPassword = request.getParameter("newPassword");
        userService.passwordUpdateUser(user.getId(),newPassword);
        user user1 = userService.validatemail(user.getEmail());
        //跳转页面
//        System.out.println(user);
        request.getSession().setAttribute("user",user1);
        request.getSession().setAttribute("updatePasswordMessage","密码修改成功！");
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/password_safe.jsp";
        return viewname;
    }


    @RequestMapping("/validatePassword")
    public @ResponseBody String uservalidatePassword(String params,HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("validatePassword");
        String email = request.getParameter("email");
        user user = userService.validatemail(email);
        if (user.getPassword()==params){
            request.getSession().setAttribute("user",user);
            return "success";
        }else return "fales";
    }

    @RequestMapping("/forgetPassword")
    public String userforgetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String s = (String)request.getSession().getAttribute("emailName");
        user user = userService.validatemail(s);
//        request.getSession().setAttribute("user",user);
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/forget_password.jsp";
        return viewname;
    }

    @RequestMapping("/sendEmail")
    public @ResponseBody String usersendEmail(String params,HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("sendEmail");
        String email = request.getParameter("email");
        user validatemail = userService.validatemail(email);
        if (validatemail!=null){
            String validateCode = MailUtils.getValidateCode(6);
            MailUtils.sendMail(email,"测试邮件随机生成的验证码是："+validateCode,"你好，这是一封测试邮件，无需回复。");
            request.getSession().setAttribute("yanzhengma",validateCode);
            return "success";
        }return "false";
    }
    @RequestMapping("/validateEmailCode")
    public String userValidateEmailCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("进来了邮箱验证");
        String s = (String)request.getSession().getAttribute("yanzhengma");
        String code = request.getParameter("code");
        if (s.equals(code)){
            System.out.println("进来了判断");
            String email = request.getParameter("email");
            user user = userService.validatemail(email);
            System.out.println(user);
            request.getSession().setAttribute("user",user);
            String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/reset_password.jsp";
            return viewname;
        }
        request.getSession().setAttribute("youxiangmessage","验证码错误");
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/forget_password.jsp";
        return viewname;
    }

    @RequestMapping("/resetPassword")
    public String userresetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("进来了重置密码页面");
        //获取当前用户信息
        user user = (user)request.getSession().getAttribute("user");
        //获取前台页面要修改的密码
        String password = request.getParameter("password");
        userService.passwordUpdateUser(user.getId(),password);
        user user1 = userService.validatemail(user.getEmail());
        //跳转页面
//        System.out.println(user);
        request.getSession().setAttribute("user",user1);
        request.getSession().setAttribute("updatePasswordMessage","密码修改成功！");
        String viewname = "redirect:http://localhost:8080/Y_web/jsp/before/password_safe.jsp";
        return viewname;
    }
}
