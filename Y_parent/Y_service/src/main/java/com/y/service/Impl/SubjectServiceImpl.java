package com.y.service.Impl;

import com.y.dao.subjectDao;
import com.y.entity.subject;
import com.y.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    subjectDao subjectDao;

    public void setSubjectDao(com.y.dao.subjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public List<subject> findAllSubject() {
        List<subject> allSubject = subjectDao.findAllSubject();
        return allSubject;
    }
}
