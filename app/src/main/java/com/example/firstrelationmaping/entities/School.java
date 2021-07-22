package com.example.firstrelationmaping.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class School {

   @PrimaryKey(autoGenerate = false)
   @NonNull
    public String SchoolName;

    public School() {
    }

    public School(String schoolName) {
        SchoolName = schoolName;
    }


    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }
}
