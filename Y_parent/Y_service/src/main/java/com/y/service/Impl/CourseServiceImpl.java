package com.y.service.Impl;

import com.y.dao.courseDao;
import com.y.entity.course;
import com.y.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    courseDao courseDao;

    public void setCourseDao(com.y.dao.courseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<course> findAllCourse() {
        List<course> list = courseDao.findAllCourse();
        return list;

    }

    public List<String> findAllCourseName() {
        List<String> list = courseDao.findAllCourseName();
        return list;
    }

    public List<course> findAll() {
        List<course> courseList = courseDao.findAll();
        return courseList;
    }

    public void InsertCourse(@Param("course_title") String ctitle, @Param("course_desc") String cdesc, @Param("subject_id") String cid){
        courseDao.InsertCourse(ctitle,cdesc,cid);
    }

    public void updateCourse(@Param("id")Integer id,@Param("course_title") String ctitle, @Param("course_desc") String cdesc,@Param("subject_id") String cid){
        courseDao.updateCourse(id,ctitle,cdesc,cid);
    }

    public course findById(Integer id) {
        course course = courseDao.findById(id);
        return course;
    }

    public void deleteCourse(Integer id) {
        courseDao.deleteCourse(id);
    }


}
