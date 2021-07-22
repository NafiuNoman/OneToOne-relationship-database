package com.example.firstrelationmaping.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class SchoolAndDirector {

    @Embedded
    public School school;


    @Relation(parentColumn = "SchoolName",entityColumn = "SchoolName")
    public Director  director;


    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
