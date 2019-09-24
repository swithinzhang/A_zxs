package com.y.dao;


import com.y.entity.video;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface videoDao {

    @Select("select * from video")
    public List<video> findAllVideo();


    @Select("SELECT * FROM video LEFT JOIN speaker on video.spearker_id = speaker.id")
    public List<video> findAllVideoAndSpeaker();

    @Select("select * from video where id=#{id}")
    public video findById(String id);

    @Insert("INSERT INTO video (title,detail,time,spearker_id,course_id,video_url,image_url) VALUES (#{title},#{detail},#{time},#{spearker_id},#{course_id},#{video_url},#{image_url})")
    public void insertVideo(@Param("title")String title,@Param("detail")String detail,@Param("time")Integer time,
                            @Param("spearker_id")Integer spearker_id,@Param("course_id")Integer course_id,
                            @Param("video_url")String video_url,@Param("image_url")String image_url);


    @Update("UPDATE video SET id=#{id},title=#{title},detail=#{detail},time=#{time},spearker_id=#{spearker_id},course_id=#{course_id},video_url=#{video_url},image_url=#{image_url} WHERE (id=#{id})")
    public void updateVideo(@Param("id")Integer id,@Param("title")String title,@Param("detail")String detail,@Param("time")Integer time,
                            @Param("spearker_id")Integer spearker_id,@Param("course_id")Integer course_id,
                            @Param("video_url")String video_url,@Param("image_url")String image_url);

    @Delete("delete from video where id=#{id}")
    public void delVideo(Integer id);

    @Select("SELECT video.id, video.title, video.detail, video.time,video.spearker_id ,video.video_url,video.image_url,video.play_num,speaker.speaker_name,speaker.id AS sid FROM video LEFT JOIN speaker ON video.spearker_id = speaker.id WHERE video.title LIKE #{title} AND speaker.id = #{sid}")
    public List<video> SelectSql(@Param("title")String title,@Param("sid") Integer id);

    @Select("SELECT video.id, video.title, video.detail, video.time,video.spearker_id ,video.course_id ,video.video_url,video.image_url,video.play_num FROM video LEFT JOIN course ON video.course_id = course.id WHERE video.title LIKE #{title} AND course_id = #{cid}")
    public List<video> SelectSqlc(@Param("title")String title,@Param("cid") Integer cid);

    @Select("SELECT * FROM video  WHERE video.title LIKE #{title}")
    public List<video> SelectSqlcc(String title);
}
