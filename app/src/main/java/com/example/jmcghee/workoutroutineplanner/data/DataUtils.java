package com.example.jmcghee.workoutroutineplanner.data;

import com.example.jmcghee.workoutroutineplanner.workout_items.Exercise;
import com.example.jmcghee.workoutroutineplanner.workout_items.Workout;
import com.example.jmcghee.workoutroutineplanner.workout_items.WorkoutSection;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    /**
     * This loads the sample workouts for the app
     */
    public static List<Workout> createDummyData(){

        List<Workout> workouts = new ArrayList();

        // Begin Rings Day Workout

        Workout ringsDay = new Workout("Rings Day");

        // Rings Day - Warm up section

        WorkoutSection ringsWarmUp = new WorkoutSection("Warm Up");

        Exercise hollowBody = new Exercise("Hollow Body");
        hollowBody.setIsIsometric(true);
        hollowBody.setHoldTime(60);
        ringsWarmUp.addExercise(hollowBody);

        Exercise reverseHollowBody = new Exercise("Reverse Hollow Body");
        reverseHollowBody.setIsIsometric(true);
        reverseHollowBody.setHoldTime(60);
        ringsWarmUp.addExercise(reverseHollowBody);

        Exercise plank = new Exercise("Plank");
        plank.setIsIsometric(true);
        plank.setHoldTime(60);
        ringsWarmUp.addExercise(plank);

        Exercise reversePlank = new Exercise("Reverse Plank");
        reversePlank.setIsIsometric(true);
        reversePlank.setHoldTime(60);
        ringsWarmUp.addExercise(reversePlank);

        Exercise sidePlank = new Exercise("Side Plank");
        sidePlank.setIsIsometric(true);
        sidePlank.setHoldTime(60);
        ringsWarmUp.addExercise(sidePlank);

        Exercise skinTheCats = new Exercise("Skin the Cats");
        skinTheCats.setReps(6);
        ringsWarmUp.addExercise(skinTheCats);

        ringsDay.addWorkoutSection(ringsWarmUp);

        // Rings Day - Skill work section

        WorkoutSection skillWork = new WorkoutSection("Skill Work");

        Exercise wallHandstand = new Exercise("Wall Handstand");
        wallHandstand.setIsIsometric(true);
        wallHandstand.setSets(2);
        wallHandstand.setHoldTime(60);
        skillWork.addExercise(wallHandstand);

        Exercise meathookWindshieldWipers = new Exercise("Meathook Windshield Wipers");
        meathookWindshieldWipers.setReps(6);
        skillWork.addExercise(meathookWindshieldWipers);

        Exercise lSit = new Exercise("L-Sit");
        lSit.setIsIsometric(true);
        lSit.setSets(2);
        lSit.setHoldTime(30);
        skillWork.addExercise(lSit);

        ringsDay.addWorkoutSection(skillWork);

        // Rings Day - Strength work section

        WorkoutSection ringsStrengthWork = new WorkoutSection("Strength Work");

        Exercise pullUps = new Exercise("Pull Ups");
        pullUps.setSets(3);
        pullUps.setReps(8);
        ringsStrengthWork.addExercise(pullUps);

        Exercise dips = new Exercise("Rings Dips");
        dips.setSets(3);
        dips.setReps(8);
        ringsStrengthWork.addExercise(dips);

        Exercise rows = new Exercise("Rings Rows");
        rows.setSets(3);
        rows.setReps(8);
        ringsStrengthWork.addExercise(rows);

        Exercise pushUps = new Exercise("Push Ups");
        pushUps.setSets(3);
        pushUps.setReps(8);
        ringsStrengthWork.addExercise(pushUps);

        ringsDay.addWorkoutSection(ringsStrengthWork);

        workouts.add(ringsDay);

        // End Rings Day Workout


        // Begin Legs Day Workout

        Workout legsDay = new Workout("Legs Day");

        // Legs Day - Warm up section

        WorkoutSection legsWarmUp = new WorkoutSection("Warm Up");

        Exercise bodyweightSquats = new Exercise("Bodyweight Squats");
        bodyweightSquats.setReps(10);
        legsWarmUp.addExercise(bodyweightSquats);

        Exercise legLiftsFront = new Exercise("Leg Lifts - Front");
        legLiftsFront.setReps(10);
        legsWarmUp.addExercise(legLiftsFront);

        Exercise legLiftsSide = new Exercise("Leg Lifts - Side");
        legLiftsSide.setReps(10);
        legsWarmUp.addExercise(legLiftsSide);

        Exercise legLiftsBack = new Exercise("Leg Lifts - Back");
        legLiftsBack.setReps(10);
        legsWarmUp.addExercise(legLiftsBack);

        Exercise cossackSquats = new Exercise("Cossack Squats");
        cossackSquats.setReps(10);
        legsWarmUp.addExercise(cossackSquats);

        legsDay.addWorkoutSection(legsWarmUp);

        // Legs Day - Strength and Mobility Section

        WorkoutSection strengthAndMobilityWork = new WorkoutSection("Strength and Mobility Work");

        Exercise backSquats = new Exercise("Back Squats");
        backSquats.setSets(4);
        backSquats.setReps(5);
        strengthAndMobilityWork.addExercise(backSquats);

        Exercise tailorsPose = new Exercise("Weighted Tailors Pose");
        tailorsPose.setIsIsometric(true);
        tailorsPose.setSets(3);
        tailorsPose.setHoldTime(60);
        strengthAndMobilityWork.addExercise(tailorsPose);

        Exercise straddleDeadlift = new Exercise("Straddle Deadlift");
        straddleDeadlift.setSets(3);
        straddleDeadlift.setReps(10);
        strengthAndMobilityWork.addExercise(straddleDeadlift);

        Exercise straddleUps = new Exercise("Straddle Ups");
        straddleUps.setReps(10);
        strengthAndMobilityWork.addExercise(straddleUps);

        Exercise middleSplit = new Exercise("Middle Split Hold");
        middleSplit.setIsIsometric(true);
        middleSplit.setSets(3);
        middleSplit.setHoldTime(120);
        strengthAndMobilityWork.addExercise(middleSplit);

        legsDay.addWorkoutSection(strengthAndMobilityWork);

        workouts.add(legsDay);

        // End "Legs Day" Workout

        return workouts;
    }
}
