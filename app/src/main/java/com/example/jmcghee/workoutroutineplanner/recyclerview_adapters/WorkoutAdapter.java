package com.example.jmcghee.workoutroutineplanner.recyclerview_adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jmcghee.workoutroutineplanner.R;
import com.example.jmcghee.workoutroutineplanner.workout_items.Workout;

import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

    final private List<Workout> workoutsList;
    final private WorkoutClickListener mOnClickListener;

    public interface WorkoutClickListener {
        void onWorkoutClicked(int index);
    }

    /**
     * Constructor
     *
     * @param workoutsList The list of workouts that will be displayed by this adapter
     */
    public WorkoutAdapter(List<Workout> workoutsList, WorkoutClickListener listener) {
        this.workoutsList = workoutsList;
        mOnClickListener = listener;
    }


    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @return A WorkoutViewHolder that will hold each workout name
     */
    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.simple_title_viewholder, parent, false);
        WorkoutViewHolder viewHolder = new WorkoutViewHolder(view);

        return viewHolder;
    }

    /**
     * This is called by the RecyclerView to display the correct data at the specified position.
     *
     * @param holder The specific ViewhHolder that will be updated
     * @param position The position of the object within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        // Set the textView in the ViewHolder to name of the workout
        holder.workoutName.setText(workoutsList.get(position).getName());
    }

    /**
     * This tells the adapter the number of items to display
     *
     * @return The number of items in the workoutList
     */
    @Override
    public int getItemCount() {
        return workoutsList.size();
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView workoutName;

        public WorkoutViewHolder(View itemView) {
            super(itemView);
            workoutName = (TextView) itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int index = getAdapterPosition();
            mOnClickListener.onWorkoutClicked(index);
        }
    }
}
