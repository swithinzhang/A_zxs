package com.y.entity;

public class subject {
    private String id;
    private String subject_name;
    public subject(){}

    @Override
    public String toString() {
        return "subject{" +
                "id='" + id + '\'' +
                ", subject_name='" + subject_name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public subject(String id, String subject_name) {
        this.id = id;
        this.subject_name = subject_name;
    }
}
