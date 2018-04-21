package com.example.jmcghee.workoutroutineplanner.recyclerview_adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jmcghee.workoutroutineplanner.R;
import com.example.jmcghee.workoutroutineplanner.workout_items.WorkoutSection;

import java.util.List;

public class WorkoutSectionsAdapter extends RecyclerView.Adapter<WorkoutSectionsAdapter.WorkoutSectionViewHolder> {

    final private List<WorkoutSection> workoutSections;
    final private WorkoutSectionClickListener mOnClickListener;

    public interface WorkoutSectionClickListener {
        void onWorkoutSectionClicked(int index);
    }

    /**
     * Constructor
     *
     * @param workoutSections The list of workouts that will be displayed by this adapter
     * @param listener The listener that will be called when clicked
     */
    public WorkoutSectionsAdapter(List<WorkoutSection> workoutSections, WorkoutSectionClickListener listener) {
        this.workoutSections = workoutSections;
        mOnClickListener = listener;
    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @return A WorkoutSectionViewHolder that will hold each workoutSection name
     */
    @NonNull
    @Override
    public WorkoutSectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.simple_name_viewholder, parent, false);
        WorkoutSectionViewHolder viewHolder = new WorkoutSectionViewHolder(view);

        return viewHolder;
    }

    /**
     * This is called by the RecyclerView to display the correct data at the specified position.
     *
     * @param holder The specific ViewhHolder that will be updated
     * @param position The position of the object within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull WorkoutSectionViewHolder holder, int position) {
        // Set the textView in the ViewHolder to name of the workoutSection
        holder.workoutSectionName.setText(workoutSections.get(position).getName());
    }

    /**
     * This tells the adapter the number of items to display
     *
     * @return The number of items in the workoutSections list
     */
    @Override
    public int getItemCount() {
        return workoutSections.size();
    }

    public class WorkoutSectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView workoutSectionName;

        public WorkoutSectionViewHolder(View itemView) {
            super(itemView);
            workoutSectionName = itemView.findViewById(R.id.tv_simple_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int index = getAdapterPosition();
            mOnClickListener.onWorkoutSectionClicked(index);
        }
    }

}
