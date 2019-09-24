package com.y.dao;


import com.y.entity.speaker;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface speakerDao {
    @Select("select * from speaker")
    public List<speaker> findAllSpeaker();

    @Select("select * from speaker where id=#{id}")
    public speaker findById(Integer id);

    @Insert("INSERT INTO speaker (speaker_name,speaker_desc,speaker_job) VALUES (#{speaker_name}, #{speaker_desc}, #{speaker_job})")
    public void insertSpeaker(@Param("speaker_name")String speaker_name,@Param("speaker_desc")String speaker_desc,@Param("speaker_job")String speaker_job);


    @Update("UPDATE `y`.`speaker` SET `id`=#{id}, `speaker_name`=#{speaker_name}, `speaker_desc`=#{speaker_desc}, `speaker_job`=#{speaker_job}  WHERE (`id`=#{id})")
    public void updateSpeaker(@Param("id") Integer id,@Param("speaker_name")String speaker_name,@Param("speaker_desc")String speaker_desc,@Param("speaker_job")String speaker_job);

    @Delete("delete from speaker where id=#{id}")
    public void deleteSpeaker(Integer id);
}
