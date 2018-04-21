package com.example.jmcghee.workoutroutineplanner.workout_items;


import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String name;
    private List<WorkoutSection> workoutSections;

    public Workout(String name) {
        this.name = name;
        workoutSections = new ArrayList();
    }

    public Workout(String name, List<WorkoutSection> workoutSections) {
        this.name = name;
        this.workoutSections = workoutSections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkoutSection> getWorkoutSections() {
        return workoutSections;
    }

    public void setWorkoutSections(List<WorkoutSection> workoutSections) {
        this.workoutSections = workoutSections;
    }

    public void addWorkoutSection(WorkoutSection section) {
        workoutSections.add(section);
    }
}
