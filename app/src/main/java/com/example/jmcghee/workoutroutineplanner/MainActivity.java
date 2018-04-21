package com.example.jmcghee.workoutroutineplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jmcghee.workoutroutineplanner.recyclerview_adapters.WorkoutsAdapter;
import com.example.jmcghee.workoutroutineplanner.workout_items.Exercise;
import com.example.jmcghee.workoutroutineplanner.workout_items.Workout;
import com.example.jmcghee.workoutroutineplanner.workout_items.WorkoutSection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WorkoutsAdapter.WorkoutClickListener {

    List<Workout> workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the recycler view
        RecyclerView workoutRecyclerView = findViewById(R.id.rv_workouts);

        // Create a layout manager for the recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Set the layout manager to the recycler view
        workoutRecyclerView.setLayoutManager(layoutManager);

        // Set fixed sized to true to improve performance
        workoutRecyclerView.setHasFixedSize(true);

        // Load the sample workouts
        workouts = createDummyData();

        // Create a new adapter with the sample workouts loaded in
        WorkoutsAdapter workoutsAdapter = new WorkoutsAdapter(workouts, this);

        // Attach the adapter to the recycler view
        workoutRecyclerView.setAdapter(workoutsAdapter);
    }

    /**
     * Starts a WorkoutSectionsActivity for a given workout
     *
     * @param index The index of the workout that was clicked
     */
    @Override
    public void onWorkoutClicked(int index) {
        Intent intent = new Intent(MainActivity.this, WorkoutSectionsActivity.class);
        // Pass the data to the next activity
        // In this case the data is the list of workoutSections of the specific Workout that was clicked
        intent.putExtra(getString(R.string.workout_sections_extra), (Serializable) workouts.get(index).getWorkoutSections());
        startActivity(intent);
    }

    /**
     * This loads the sample workouts for the app
     */
    private List<Workout> createDummyData(){

        List<Workout> workouts = new ArrayList();

        Workout ringsDay = new Workout("Rings Day");

        // Warm up section

        WorkoutSection ringsWarmUp = new WorkoutSection("Warm Up");

        Exercise hollowBody = new Exercise("Hollow Body");
        hollowBody.setHoldTime(60);
        ringsWarmUp.addExercise(hollowBody);

        Exercise reverseHollowBody = new Exercise("Reverse Hollow Body");
        reverseHollowBody.setHoldTime(60);
        ringsWarmUp.addExercise(reverseHollowBody);

        Exercise plank = new Exercise("Plank");
        plank.setHoldTime(60);
        ringsWarmUp.addExercise(plank);

        Exercise reversePlank = new Exercise("Reverse Plank");
        reversePlank.setHoldTime(60);
        ringsWarmUp.addExercise(reversePlank);

        Exercise sidePlank = new Exercise("Side Plank");
        sidePlank.setHoldTime(60);
        ringsWarmUp.addExercise(sidePlank);

        Exercise skinTheCats = new Exercise("Skin the Cats");
        skinTheCats.setReps(6);
        ringsWarmUp.addExercise(skinTheCats);

        ringsDay.addWorkoutSection(ringsWarmUp);

        // Skill work section

        WorkoutSection skillWork = new WorkoutSection("Skill Work");

        Exercise wallHandstand = new Exercise("Wall Handstand");
        wallHandstand.setHoldTime(60);
        skillWork.addExercise(wallHandstand);

        Exercise meathookWindshieldWipers = new Exercise("Meathook Windshield Wipers");
        meathookWindshieldWipers.setReps(6);
        skillWork.addExercise(meathookWindshieldWipers);

        Exercise lSit = new Exercise("L-Sit");
        lSit.setHoldTime(30);
        skillWork.addExercise(lSit);

        ringsDay.addWorkoutSection(skillWork);

        // Strength work section

        WorkoutSection strengthWork = new WorkoutSection("Strength Work");

        Exercise pullUps = new Exercise("Pull Ups");
        pullUps.setSets(3);
        pullUps.setReps(8);
        strengthWork.addExercise(pullUps);

        Exercise dips = new Exercise("Rings Dips");
        dips.setSets(3);
        dips.setReps(8);
        strengthWork.addExercise(dips);

        Exercise rows = new Exercise("Rings Rows");
        rows.setSets(3);
        rows.setReps(8);
        strengthWork.addExercise(rows);

        Exercise pushUps = new Exercise("Push Ups");
        pushUps.setSets(3);
        pushUps.setReps(8);
        strengthWork.addExercise(pushUps);

        ringsDay.addWorkoutSection(strengthWork);

        workouts.add(ringsDay);

        return workouts;
    }


}
