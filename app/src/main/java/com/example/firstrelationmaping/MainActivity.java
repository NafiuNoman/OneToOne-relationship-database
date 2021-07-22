package com.example.firstrelationmaping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.firstrelationmaping.entities.Director;
import com.example.firstrelationmaping.entities.School;
import com.example.firstrelationmaping.entities.SchoolAndDirector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyDatabase myDatabase;

    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDatabase = MyDatabase.getInstance(this);

        School school = new School("BAF");
        School school2 = new School("BSI");
        School school3 = new School("KGF");

        Director director = new Director("Noman", "BAF");
        Director director2 = new Director("Abdulllah", "KGF");
        Director director3 = new Director("Hasbullah", "BSI");


        myDatabase.getDao().insertStudent(school, school2, school3);
        myDatabase.getDao().insertDirector(director, director2, director3);

//  one to one relationship without name returns all 3 list
       List<SchoolAndDirector> directorList =  myDatabase.getDao().getDataWithOutName();

        Log.d ("ListSize.... ",""+directorList.size());

        for (SchoolAndDirector list: directorList)
        {
            Log.d("Director Name : ",""+ list.getDirector().getDirectorName()+" His School :"+list.getDirector().getSchoolName()+"\n");
        }



//  one to one relationship with single name returns only that particular  item of SchoolAndDirector

        List<SchoolAndDirector> DandS= myDatabase.getDao().getSchoolAndDirectorNameWithSchoolName("BSI");

        for(SchoolAndDirector list: DandS)
        {
            Log.d("WithName..","Director Name :"+list.getDirector().getDirectorName()+"School Name :"+list.getSchool().getSchoolName()+"\n");
        }

        //  one to one relationship with multiple  name returns multiple same  item of SchoolAndDirector

        List<SchoolAndDirector> DandSA= myDatabase.getDao().getSchoolAndDirectorNameWithSchoolNames("BSI","KGF");

        for(SchoolAndDirector list: DandSA)
        {
            Log.d("WithManyNames..","Director Name :"+list.getDirector().getDirectorName()+"School Name :"+list.getSchool().getSchoolName()+"\n");
        }





    }

    public void doDeleteDirectors(View view) {

        myDatabase.getDao().deleteRowDirector("Rakib","Zafar");


    }
}