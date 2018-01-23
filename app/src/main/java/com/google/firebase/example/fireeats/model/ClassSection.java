package com.google.firebase.example.fireeats.model;

import java.util.ArrayList;

/**
 * Created by tp0986611 on 1/19/2018.
 */

public class ClassSection {

    public String id; //like crn number
    public String name;
    public ArrayList<String> teachers;
    public String description;
    public String time;
    //public ArrayList preq; //pre-requisite
    public String roomNumber;
    public int seats; //max students allowed

    public ClassSection(){}

    public ClassSection(String id, String name, ArrayList<String> teachers, String description, String time,
                        String roomNumber, int seats /*, ArrayList preq*/ ) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
        this.description = description;
        this.time = time;
        //this.preq = preq;
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

    public ArrayList<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<String> teachers) {
        this.teachers = teachers;
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

    /*public ArrayList getPreq() {
        return preq;
    }

    public void setPreq(ArrayList preq) {
        this.preq = preq;
    }*/

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
