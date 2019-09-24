package com.y.dao;

import com.y.entity.course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface courseDao {
    @Select("select * from course")
    public List<course> findAllCourse();

    @Select("select course_title from course")
    public List<String> findAllCourseName();

    @Select("SELECT course.id,course.course_title,course.course_desc,course.subject_id,`subject`.id,`subject`.subject_name FROM course INNER JOIN `subject` ON course.subject_id = `subject`.id")
    public List<course> findAll();

    @Insert("INSERT INTO `y`.`course` ( `course_title`, `course_desc`, `subject_id`) VALUES (#{course_title}, #{course_desc}, #{subject_id})")
    public void InsertCourse(@Param("course_title") String course_title, @Param("course_desc") String course_desc,@Param("subject_id") String subject_id);

    @Update("UPDATE `y`.`course` SET `id`=#{id}, `course_title`=#{course_title}, `course_desc`=#{course_desc}, `subject_id`=#{subject_id} WHERE (`id`=#{subject_id});")
    public void updateCourse(@Param("id")Integer id,@Param("course_title") String course_title, @Param("course_desc") String course_desc,@Param("subject_id") String subject_id);

    @Select("select * from course where id=#{id}")
    public course findById(Integer id);

    @Delete("delete from course where id=#{id}")
    public void deleteCourse(Integer id);
}
