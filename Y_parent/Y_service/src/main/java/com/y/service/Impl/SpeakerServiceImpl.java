package com.y.service.Impl;

import com.y.dao.speakerDao;
import com.y.entity.speaker;
import com.y.service.speakerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("speakerService")
public class SpeakerServiceImpl implements speakerService {
    @Autowired
    speakerDao speakerDao;

    public void setSpeakerDao(com.y.dao.speakerDao speakerDao) {
        this.speakerDao = speakerDao;
    }

    public List<speaker> findAllSpeaker() {
        List<speaker> allSpeaker = speakerDao.findAllSpeaker();
        return allSpeaker;
    }

    public speaker findById(Integer id) {
        speaker speaker = speakerDao.findById(id);
        return speaker;

    }

    public void insertSpeaker(@Param("speaker_name")String spname, @Param("speaker_desc")String spdesc, @Param("speaker_job")String spjob){
       speakerDao.insertSpeaker(spname,spdesc,spjob);
    }

    public void updateSpeaker(@Param("id") Integer id,@Param("speaker_name")String spname,@Param("speaker_desc")String spdesc,@Param("speaker_job")String spjob) {
        speakerDao.updateSpeaker(id,spname,spdesc,spjob);
    }

    public void deleteSpeaker(Integer id) {
        speakerDao.deleteSpeaker(id);
    }
}
