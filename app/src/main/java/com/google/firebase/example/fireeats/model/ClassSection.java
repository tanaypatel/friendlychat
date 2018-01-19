package com.google.firebase.example.fireeats.model;

import java.util.List;

/**
 * Created by tp0986611 on 1/19/2018.
 */

public class ClassSection {

    public String id; //like crn number
    public String name;
    public String teacherName;
    public String description;
    public String time;
    public List preq; //pre-requisite
    public String roomNumber;
    public int seats; //max students allowed

    public ClassSection(String id, String name, String teacherName, String description, String time,
                        List preq, String roomNumber, int seats) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
        this.description = description;
        this.time = time;
        this.preq = preq;
        this.roomNumber = roomNumber;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List getPreq() {
        return preq;
    }

    public void setPreq(List preq) {
        this.preq = preq;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
