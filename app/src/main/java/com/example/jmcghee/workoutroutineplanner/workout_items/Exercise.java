package com.example.jmcghee.workoutroutineplanner.workout_items;

public class Exercise {
    private String name;
    private int sets;
    private boolean isIsometric;
    private int reps;
    private int holdTime;

    public Exercise(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public boolean isIsometric() {
        return isIsometric;
    }

    public void setIsometric(boolean isIsometric) {
        this.isIsometric = isIsometric;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(int holdTime) {
        this.holdTime = holdTime;
    }
}
