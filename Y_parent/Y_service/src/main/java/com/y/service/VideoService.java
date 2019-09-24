package com.y.service;

import com.y.entity.video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoService {
    public List<video> findAllVideo();

    public List<video> findAllVideoAndSpeaker();

    public video findById(String id);

    public void insertVideo(String title,String detail,Integer time,Integer spearker_id,Integer course_id,String video_url,String image_url);

    public void updateVideo(Integer id,String title,String detail,Integer time,Integer spearker_id,Integer course_id,String video_url,String image_url);

    public void delVideo(Integer id);

    public List<video> SelectSql(String title, Integer id);

    public List<video> SelectSqlc(String title,Integer id);

    public List<video> SelectSqlcc(String title);
}
