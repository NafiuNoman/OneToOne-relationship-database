package com.example.firstrelationmaping;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.firstrelationmaping.entities.Director;
import com.example.firstrelationmaping.entities.School;
import com.example.firstrelationmaping.entities.SchoolAndDirector;

import java.util.List;

@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(School... schools);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDirector(Director... directors);

    @Transaction
    @Query("SELECT * FROM School WHERE schoolname= :schoolName")
    List<SchoolAndDirector> getSchoolAndDirectorNameWithSchoolName(String schoolName);


    @Transaction
    @Query("SELECT * FROM School WHERE schoolname IN  (:schoolNames)")
    List<SchoolAndDirector> getSchoolAndDirectorNameWithSchoolNames(String... schoolNames);



    @Transaction
    @Query("SELECT * FROM School")
    List<SchoolAndDirector> getDataWithOutName();


    @Query("DELETE FROM Director WHERE DirectorName IN ( :DNames)")
    void deleteRowDirector(String... DNames);


}
