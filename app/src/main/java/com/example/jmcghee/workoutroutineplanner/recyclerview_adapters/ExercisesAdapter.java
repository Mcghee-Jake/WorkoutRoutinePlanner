package com.example.jmcghee.workoutroutineplanner.recyclerview_adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jmcghee.workoutroutineplanner.R;
import com.example.jmcghee.workoutroutineplanner.workout_items.Exercise;

import java.util.List;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ExerciseViewHolder> {

    final private List<Exercise> exercises;

    /**
     * Constructor
     *
     * @param exercises The list of exercises that will be displayed by this adapter
     */
    public ExercisesAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @return A ExerciseViewHolder that will hold each exercise information
     */
    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.exercise_viewholder, parent, false);
        ExerciseViewHolder viewHolder = new ExerciseViewHolder(view);

        return viewHolder;
    }

    /**
     * This is called by the RecyclerView to display the correct data at the specified position.
     *
     * @param holder The specific ViewhHolder that will be updated
     * @param position The position of the object within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {

        // Get the correct exercise in the list
        Exercise exercise = exercises.get(position);

        // Set the name textView in the ViewHolder to name of the exercise
        holder.exerciseName.setText(exercise.getName());

        // Set the setAndReps textView in the ViewHolder to display the exercise volume information

        // Exit if no reps or hold time is entered
        if (!exercise.isIsometric() && exercise.getReps() <= 0 || exercise.isIsometric() && exercise.getHoldTime() <= 0) {
            return;
        }

        String setsAndRepsString = "";

        // Add set volume if greater than 0
        if (exercise.getSets() > 0) {
            setsAndRepsString += exercise.getSets() + " Sets X ";
        }

        if (!exercise.isIsometric()) {
            // If it is not an isometric exercise, add the number of reps
            setsAndRepsString += exercise.getReps() + " Reps";
        } else {
            // If it is an isometric exercise

            // Format the hold time from seconds into minutes:seconds
            int time = exercise.getHoldTime();
            int minutes = time / 60;
            int seconds = time  % 60;
            String holdTimeString = String.format("%d:%02d", minutes, seconds);

            // Add the hold time
            setsAndRepsString += holdTimeString + " Hold";
        }

        // Add the setsAndReps string
        holder.setsAndReps.setText(setsAndRepsString);
    }

    /**
     * This tells the adapter the number of items to display
     *
     * @return The number of items in the workoutList
     */
    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder  {

        TextView exerciseName;
        TextView setsAndReps;

        public ExerciseViewHolder(View itemView) {
            super(itemView);
            exerciseName = itemView.findViewById(R.id.tv_exercise_name);
            setsAndReps = itemView.findViewById(R.id.tv_sets_and_reps);
        }
    }
}
