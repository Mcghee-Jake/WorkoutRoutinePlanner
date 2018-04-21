package com.example.jmcghee.workoutroutineplanner.workout_items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkoutSection implements Serializable {
    private String name;
    private List<Exercise> exercises;

    public WorkoutSection(String name) {
        this.name = name;
        exercises = new ArrayList();
    }

    public WorkoutSection(String name, List<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }
}
