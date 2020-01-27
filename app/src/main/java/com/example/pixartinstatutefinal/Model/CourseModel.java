package com.example.pixartinstatutefinal.Model;

public class CourseModel {
    String uid;
    String courseId;
    String courseCategory;
    String course;
    String courseName;
    String courseDescription;
    String courseDurationTitle;
    String courseDurationDescription;
    String courseContentTitle;
    String courseContentDescription;
    String courseSoftwareToLearnTitle;
    String courseSoftwareToLearnDescription;
    String courseCareerOptionTitle;
    String courseCareerOptionDescription;


    public CourseModel() {
    }

    public CourseModel(String uid, String courseId, String courseCategory, String course, String courseName, String courseDescription, String courseDurationTitle, String courseDurationDescription, String courseContentTitle, String courseContentDescription, String courseSoftwareToLearnTitle, String courseSoftwareToLearnDescription, String courseCareerOptionTitle, String courseCareerOptionDescription) {
        this.uid = uid;
        this.courseId = courseId;
        this.courseCategory = courseCategory;
        this.course = course;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseDurationTitle = courseDurationTitle;
        this.courseDurationDescription = courseDurationDescription;
        this.courseContentTitle = courseContentTitle;
        this.courseContentDescription = courseContentDescription;
        this.courseSoftwareToLearnTitle = courseSoftwareToLearnTitle;
        this.courseSoftwareToLearnDescription = courseSoftwareToLearnDescription;
        this.courseCareerOptionTitle = courseCareerOptionTitle;
        this.courseCareerOptionDescription = courseCareerOptionDescription;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseDurationTitle() {
        return courseDurationTitle;
    }

    public void setCourseDurationTitle(String courseDurationTitle) {
        this.courseDurationTitle = courseDurationTitle;
    }

    public String getCourseDurationDescription() {
        return courseDurationDescription;
    }

    public void setCourseDurationDescription(String courseDurationDescription) {
        this.courseDurationDescription = courseDurationDescription;
    }

    public String getCourseContentTitle() {
        return courseContentTitle;
    }

    public void setCourseContentTitle(String courseContentTitle) {
        this.courseContentTitle = courseContentTitle;
    }

    public String getCourseContentDescription() {
        return courseContentDescription;
    }

    public void setCourseContentDescription(String courseContentDescription) {
        this.courseContentDescription = courseContentDescription;
    }

    public String getCourseSoftwareToLearnTitle() {
        return courseSoftwareToLearnTitle;
    }

    public void setCourseSoftwareToLearnTitle(String courseSoftwareToLearnTitle) {
        this.courseSoftwareToLearnTitle = courseSoftwareToLearnTitle;
    }

    public String getCourseSoftwareToLearnDescription() {
        return courseSoftwareToLearnDescription;
    }

    public void setCourseSoftwareToLearnDescription(String courseSoftwareToLearnDescription) {
        this.courseSoftwareToLearnDescription = courseSoftwareToLearnDescription;
    }

    public String getCourseCareerOptionTitle() {
        return courseCareerOptionTitle;
    }

    public void setCourseCareerOptionTitle(String courseCareerOptionTitle) {
        this.courseCareerOptionTitle = courseCareerOptionTitle;
    }

    public String getCourseCareerOptionDescription() {
        return courseCareerOptionDescription;
    }

    public void setCourseCareerOptionDescription(String courseCareerOptionDescription) {
        this.courseCareerOptionDescription = courseCareerOptionDescription;
    }
}
