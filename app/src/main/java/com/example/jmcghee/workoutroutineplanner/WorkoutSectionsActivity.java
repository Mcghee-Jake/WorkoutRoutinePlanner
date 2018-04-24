package com.example.jmcghee.workoutroutineplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jmcghee.workoutroutineplanner.recyclerview_adapters.WorkoutSectionsAdapter;
import com.example.jmcghee.workoutroutineplanner.database.model.WorkoutSection;

import java.io.Serializable;
import java.util.List;

public class WorkoutSectionsActivity extends AppCompatActivity implements WorkoutSectionsAdapter.WorkoutSectionClickListener {

    List<WorkoutSection> workoutSections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_sections);

        Intent intentThatStartedThisActivity = getIntent();
        // Make sure the data was retrieved correctly
        if (intentThatStartedThisActivity.hasExtra(getString(R.string.workout_sections_extra))) {
            // Get the workoutSections of the workout that was clicked in the previous activity
            workoutSections = (List<WorkoutSection>) intentThatStartedThisActivity.getSerializableExtra(getString(R.string.workout_sections_extra));

            // Initialize the recycler view
            RecyclerView workoutSectionsRecyclerView = findViewById(R.id.rv_workout_sections);

            // Create a layout manager for the recycler view
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);

            // Set the layout manager to the recycler view
            workoutSectionsRecyclerView.setLayoutManager(layoutManager);

            // Set fixed sized to true to improve performance
            workoutSectionsRecyclerView.setHasFixedSize(true);

            // Create a new adapter with the workout sections
            WorkoutSectionsAdapter workoutSectionsAdapter = new WorkoutSectionsAdapter(workoutSections, this);

            // Attach the adapter to the recycler view
            workoutSectionsRecyclerView.setAdapter(workoutSectionsAdapter);
        }
    }

    /**
     * Starts an ExerciseActivity for a given workoutSection
     *
     * @param index The index of the workout that was clicked
     */
    @Override
    public void onWorkoutSectionClicked(int index) {
        Intent intent = new Intent(WorkoutSectionsActivity.this, ExercisesActivity.class);
        // Pass the data to the next activity
        // In this case the data is the list of exercies in the specific Workout that was clicked
        intent.putExtra(getString(R.string.exercises_extra), (Serializable) workoutSections.get(index).getExercises());
        startActivity(intent);
    }
}
