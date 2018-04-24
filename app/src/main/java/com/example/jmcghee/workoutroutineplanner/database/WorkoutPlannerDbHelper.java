package com.example.jmcghee.workoutroutineplanner.database;

import com.example.jmcghee.workoutroutineplanner.database.WorkoutPlannerContract.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WorkoutPlannerDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "WorkoutPlannerDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public WorkoutPlannerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WORKOUT_TABLE =
                "CREATE TABLE " + workout.TABLE_NAME +
                " (" +
                workout._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                workout.COLUMN_NAME + " TEXT NOT NULL"
                + ");";

        db.execSQL(SQL_CREATE_WORKOUT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + workout.TABLE_NAME);
        onCreate(db);
    }
}
