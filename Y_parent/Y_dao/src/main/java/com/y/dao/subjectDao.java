package com.y.dao;

import com.y.entity.subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface subjectDao {

    @Select("select * from subject")
    public List<subject> findAllSubject();


}
