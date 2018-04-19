package com.example.jmcghee.workoutroutineplanner.workout_items;

import java.util.ArrayList;

public class WorkoutSection {
    private String name;
    private ArrayList<Exercise> exercises;

    public WorkoutSection(String name) {
        this.name = name;
    }

    public WorkoutSection(String name, ArrayList<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
}
