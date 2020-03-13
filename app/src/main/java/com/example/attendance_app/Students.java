package com.example.attendance_app;

public class Students {
    private String studenId;
    private String studentName;
    private String gceId;

    public  Students(){

    }

    public Students(String studenId, String studentName, String gceId) {
        this.studenId = studenId;
        this.studentName = studentName;
        this.gceId = gceId;
    }

    public String getStudenId() {
        return studenId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getgceId() {
        return gceId;
    }
}

