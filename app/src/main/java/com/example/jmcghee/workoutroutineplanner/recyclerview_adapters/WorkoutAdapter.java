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

    private List<Workout> workoutsList;

    public WorkoutAdapter(List<Workout> workoutsList) {
        this.workoutsList = workoutsList;
    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     */
    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.simple_title_viewholder, parent, false);
        WorkoutViewHolder viewHolder = new WorkoutViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder {

        TextView workoutName;

        public WorkoutViewHolder(View itemView) {
            super(itemView);
            workoutName = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
