package com.y.entity;

public class course {
    private Integer id;
    private String course_title;
    private String course_desc;
    private String subject_id;
    private String subject_name;

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", course_title='" + course_title + '\'' +
                ", course_desc='" + course_desc + '\'' +
                ", subject_id='" + subject_id + '\'' +
                ", subject_name='" + subject_name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_desc() {
        return course_desc;
    }

    public void setCourse_desc(String course_desc) {
        this.course_desc = course_desc;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public course(Integer id, String course_title, String course_desc, String subject_id, String subject_name) {
        this.id = id;
        this.course_title = course_title;
        this.course_desc = course_desc;
        this.subject_id = subject_id;
        this.subject_name = subject_name;
    }

    public course(){}


}
