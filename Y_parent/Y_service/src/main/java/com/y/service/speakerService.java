package com.y.service;

import com.y.entity.speaker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface speakerService {
    public List<speaker> findAllSpeaker();

    public speaker findById(Integer id);

    public void insertSpeaker(String speaker_name,String speaker_desc,String speaker_job);

    public void updateSpeaker(Integer id,String speaker_name,String speaker_desc,String speaker_job);

    public void deleteSpeaker(Integer id);
}
