package com.example.jmcghee.workoutroutineplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jmcghee.workoutroutineplanner.recyclerview_adapters.WorkoutSectionsAdapter;
import com.example.jmcghee.workoutroutineplanner.workout_items.WorkoutSection;

import java.util.List;

public class WorkoutSectionsActivity extends AppCompatActivity implements WorkoutSectionsAdapter.WorkoutSectionClickListener {

    List<WorkoutSection> workoutSections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_sections);

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(getString(R.string.workout_sections_extra))) {
            workoutSections = (List<WorkoutSection>) intentThatStartedThisActivity.getSerializableExtra(getString(R.string.workout_sections_extra));

            // Initialize the recycler view
            RecyclerView workoutSectionsRecyclerView = findViewById(R.id.rv_workout_sections);

            // Create a layout manager for the recycler view
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);

            // Set the layout manager to the recycler view
            workoutSectionsRecyclerView.setLayoutManager(layoutManager);

            // Set fixed sized to true to improve performance
            workoutSectionsRecyclerView.setHasFixedSize(true);

            // Create a new adapter with the sample workouts loaded in
            WorkoutSectionsAdapter workoutSectionsAdapter = new WorkoutSectionsAdapter(workoutSections, this);

            // Attach the adapter to the recycler view
            workoutSectionsRecyclerView.setAdapter(workoutSectionsAdapter);
        }
    }


    @Override
    public void onWorkoutSectionClicked(int index) {
        Toast.makeText(this, "Element " + index + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
