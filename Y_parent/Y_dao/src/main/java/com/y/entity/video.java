package com.y.entity;

public class video {
    private Integer id;
    private String title;
    private String detail;
    private Integer time;
    private Integer spearker_id;
    private Integer course_id;
    private String video_url;
    private String image_url;
    private Integer play_num;
    private String speaker_name;
    private String course_title;
    private video video;
    private user user;
    public video(){}

    @Override
    public String toString() {
        return "video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", time=" + time +
                ", spearker_id=" + spearker_id +
                ", course_id=" + course_id +
                ", video_url='" + video_url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", play_num=" + play_num +
                ", speaker_name='" + speaker_name + '\'' +
                ", course_title='" + course_title + '\'' +
                ", video=" + video +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getSpearker_id() {
        return spearker_id;
    }

    public void setSpearker_id(Integer spearker_id) {
        this.spearker_id = spearker_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Integer play_num) {
        this.play_num = play_num;
    }

    public String getSpeaker_name() {
        return speaker_name;
    }

    public void setSpeaker_name(String speaker_name) {
        this.speaker_name = speaker_name;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public com.y.entity.video getVideo() {
        return video;
    }

    public void setVideo(com.y.entity.video video) {
        this.video = video;
    }

    public com.y.entity.user getUser() {
        return user;
    }

    public void setUser(com.y.entity.user user) {
        this.user = user;
    }

    public video(Integer id, String title, String detail, Integer time, Integer spearker_id, Integer course_id, String video_url, String image_url, Integer play_num, String speaker_name, String course_title, com.y.entity.video video, com.y.entity.user user) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.time = time;
        this.spearker_id = spearker_id;
        this.course_id = course_id;
        this.video_url = video_url;
        this.image_url = image_url;
        this.play_num = play_num;
        this.speaker_name = speaker_name;
        this.course_title = course_title;
        this.video = video;
        this.user = user;
    }
}
