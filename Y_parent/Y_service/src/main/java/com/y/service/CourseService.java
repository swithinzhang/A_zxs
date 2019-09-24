package com.y.service;

import com.y.entity.course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService {
    public List<course> findAllCourse();

    public List<String> findAllCourseName();

    public List<course> findAll();

    public void InsertCourse(String ctitle,String cdesc,String cid);

    public void updateCourse(Integer id, String ctitle, String cdesc, String cid);

    public course findById(Integer id);

    public void deleteCourse(Integer id);
}
