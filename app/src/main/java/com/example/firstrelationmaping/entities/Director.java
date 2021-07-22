package com.example.firstrelationmaping.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Director {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    public String DirectorName;

    public String SchoolName;

    public Director() {
    }

    public Director(String directorName, String schoolName) {
        DirectorName = directorName;
        SchoolName = schoolName;
    }

    public String getDirectorName() {
        return DirectorName;
    }

    public void setDirectorName(String directorName) {
        DirectorName = directorName;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }
}
