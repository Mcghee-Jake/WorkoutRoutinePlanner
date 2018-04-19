package com.example.jmcghee.workoutroutineplanner.workout_items;

import java.util.ArrayList;

public class Workout {
    private String name;
    private ArrayList<WorkoutSection> workoutSections;

    public Workout(String name) {
        this.name = name;
    }

    public Workout(String name, ArrayList<WorkoutSection> workoutSections) {
        this.name = name;
        this.workoutSections = workoutSections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WorkoutSection> getWorkoutSections() {
        return workoutSections;
    }

    public void setWorkoutSections(ArrayList<WorkoutSection> workoutSections) {
        this.workoutSections = workoutSections;
    }
}
