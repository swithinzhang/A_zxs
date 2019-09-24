package com.y.service.Impl;

import com.y.dao.videoDao;
import com.y.entity.video;
import com.y.service.VideoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("videoService")
public class VideoServiceImpl implements VideoService {
    @Autowired
    videoDao videoDao;

    public void setVideoDao(com.y.dao.videoDao videoDao) {
        this.videoDao = videoDao;
    }

    public List<video> findAllVideo() {
        List<video> allVideo = videoDao.findAllVideo();
        return allVideo;
    }

    public List<video> findAllVideoAndSpeaker() {
        List<video> allVideoAndSpeaker = videoDao.findAllVideoAndSpeaker();
        return allVideoAndSpeaker;
    }

    public video findById(String id) {
        video video = videoDao.findById(id);
        return video;
    }

    public void insertVideo(@Param("title")String title, @Param("detail")String detail, @Param("time")Integer time,
                            @Param("spearker_id")Integer spearker_id, @Param("course_id")Integer course_id,
                            @Param("video_url")String video_url, @Param("image_url")String image_url){
        videoDao.insertVideo(title,detail,time,spearker_id,course_id,video_url,image_url);
    }

    public void updateVideo(@Param("id")Integer id,@Param("title")String title,@Param("detail")String detail,@Param("time")Integer time,
                            @Param("spearker_id")Integer spearker_id,@Param("course_id")Integer course_id,
                            @Param("video_url")String video_url,@Param("image_url")String image_url){
        videoDao.updateVideo(id,title,detail,time,spearker_id,course_id,video_url,image_url);

    }

    public void delVideo(Integer id) {
        videoDao.delVideo(id);
    }

    public List<video> SelectSql(@Param("title")String title, @Param("sid") Integer id){
        return  videoDao.SelectSql(title,id);
    }

    public List<video> SelectSqlc(@Param("title")String title,@Param("cid") Integer cid) {
        return videoDao.SelectSqlc(title,cid);
    }

    public List<video> SelectSqlcc(String title){
        return videoDao.SelectSqlcc(title);
    }


}
