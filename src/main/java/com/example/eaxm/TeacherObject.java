package com.example.eaxm;

public class TeacherObject {
    private String name;
    private String course;
    private int experience;
    private int addMissionNo;
    public TeacherObject(String name,String course,int experience){
        this.name=name;
        this.course=course;
        this.experience=experience;
    }


    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAddMissionNo() {
        return addMissionNo;
    }

    public void setAddMissionNo(int addMissionNo) {
        this.addMissionNo = addMissionNo;
    }
}
