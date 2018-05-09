package com.example.jmcghee.workoutroutineplanner;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.jmcghee.workoutroutineplanner.database.DataUtils;
import com.example.jmcghee.workoutroutineplanner.database.WorkoutPlannerContract;
import com.example.jmcghee.workoutroutineplanner.database.WorkoutPlannerDbHelper;
import com.example.jmcghee.workoutroutineplanner.recyclerview_adapters.WorkoutAdapter;
import com.example.jmcghee.workoutroutineplanner.database.model.Workout;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WorkoutAdapter.WorkoutClickListener {

    private WorkoutAdapter workoutAdapter;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the database
        final WorkoutPlannerDbHelper dbHelper = new WorkoutPlannerDbHelper(this);
        mDb = dbHelper.getWritableDatabase();

        // Initialize the recycler view
        final RecyclerView workoutRecyclerView = findViewById(R.id.rv_workouts);

        // Create a layout manager for the recycler view
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Set the layout manager to the recycler view
        workoutRecyclerView.setLayoutManager(layoutManager);

        // Set fixed sized to true to improve performance
        workoutRecyclerView.setHasFixedSize(true);

        // Create a new adapter with the sample workouts loaded in
        workoutAdapter = new WorkoutAdapter(getAllWorkouts(), this);

        // Attach the adapter to the recycler view
        workoutRecyclerView.setAdapter(workoutAdapter);

        // Setup the FAB
        final FloatingActionButton fab = findViewById(R.id.fab_workout);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWorkoutDialog();
            }
        });
    }

    private Cursor getAllWorkouts() {
        return mDb.query(
                WorkoutPlannerContract.workout.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                WorkoutPlannerContract.workout.COLUMN_NAME
        );
    }

    /**
     * Shows the dialog to add a new workout to the list
     */
    private void showWorkoutDialog() {
        // Build the dialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        final View dialogView = (inflater.inflate(R.layout.workout_dialog, null));
        builder.setView(dialogView);

        final EditText workoutNameEditText = dialogView.findViewById(R.id.et_workout_dialog);

        builder.setTitle(R.string.workout_dialog_title);
        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the name of the workout
                final String workoutName = workoutNameEditText.getText().toString();
                // Add it to the database
                addWorkoutToDatabase(workoutName);
                // Update the adapter
                workoutAdapter.updateCursor(getAllWorkouts());
            }
        });

        // Create the dialog
        final AlertDialog dialog = builder.create();

        // Show the dialog
        dialog.show();
    }

    private long addWorkoutToDatabase(String name) {
        ContentValues cv = new ContentValues();
        cv.put(WorkoutPlannerContract.workout.COLUMN_NAME, name);

        return mDb.insert(WorkoutPlannerContract.workout.TABLE_NAME, null, cv);
    }

    /**
     * Starts a WorkoutSectionsActivity for a given workout
     *
     * @param index The index of the workout that was clicked
     */
    @Override
    public void onWorkoutClicked(int index) {
        final Intent intent = new Intent(MainActivity.this, WorkoutSectionsActivity.class);
        // Pass the data to the next activity
        // In this case the data is the list of workoutSections in the specific Workout that was clicked

       // intent.putExtra(getString(R.string.workout_sections_extra), (Serializable) workouts.get(index).getWorkoutSections());
        startActivity(intent);
    }

}
