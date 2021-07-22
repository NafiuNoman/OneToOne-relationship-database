package com.example.firstrelationmaping;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.firstrelationmaping.entities.Director;
import com.example.firstrelationmaping.entities.School;

@Database(entities = {School.class, Director.class},version = 1)
public  abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao getDao();

    private static MyDatabase INSTANCE=null;

    public static MyDatabase getInstance(Context context)
    {

        if (INSTANCE ==null)
        {
            INSTANCE = Room.databaseBuilder(context,MyDatabase.class,"MYDATABASE")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;




    }





}
