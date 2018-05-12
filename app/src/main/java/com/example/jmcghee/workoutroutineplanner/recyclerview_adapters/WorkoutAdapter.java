package com.example.jmcghee.workoutroutineplanner.recyclerview_adapters;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jmcghee.workoutroutineplanner.ActionModeAdapterCallbacks;
import com.example.jmcghee.workoutroutineplanner.R;
import com.example.jmcghee.workoutroutineplanner.database.WorkoutPlannerContract;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>
    implements ActionModeAdapterCallbacks {

    private Cursor workoutsCursor;
    private final WorkoutClickListener mOnClickListener;
    private final SparseBooleanArray selectedItemIds;


    public interface WorkoutClickListener {
        void onWorkoutClicked(int index);
    }

    /**
     * Constructor
     *
     * @param workoutsCursor The list of workoutsCursor that will be displayed by this adapter
     * @param listener The listener that will be called when clicked
     */
    public WorkoutAdapter(Cursor workoutsCursor, WorkoutClickListener listener) {
        this.workoutsCursor = workoutsCursor;
        mOnClickListener = listener;
        selectedItemIds = new SparseBooleanArray();
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
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.simple_name_viewholder, parent, false);
        final WorkoutViewHolder viewHolder = new WorkoutViewHolder(view);

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
        if (!workoutsCursor.moveToPosition(position))
            return; // exit if returned null
        // Get the name of the workout
        final String name = workoutsCursor.getString(workoutsCursor.getColumnIndex(WorkoutPlannerContract.workout.COLUMN_NAME));
        // Set the textView in the ViewHolder to the name of the workout
        holder.workoutName.setText(name);
        // Change the view state if the item gets selected on long press
        holder.itemView.setActivated(selectedItemIds.get(position));

    }

    /**
     * This tells the adapter the number of items to display
     *
     * @return The number of items in the workoutsCursor list
     */
    @Override
    public int getItemCount() {
        return workoutsCursor.getCount();
    }

    @Override
    public void toggleSelection(int position) {
        if (selectedItemIds.get(position)) {
            selectedItemIds.delete(position);
        } else {
            selectedItemIds.put(position, true);
        }
        notifyItemChanged(position);
    }

    @Override
    public void clearSelections() {
        selectedItemIds.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getSelectedCount() {
        return selectedItemIds.size();
    }

    public void updateCursor(Cursor newCursor) {
        // Exit if new cursor is null
        if (newCursor == null) return;
        // Close the old cursor
        if (workoutsCursor != null) workoutsCursor.close();
        // Switch to the new cursor
        workoutsCursor = newCursor;
        this.notifyDataSetChanged();
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        final TextView workoutName;

        public WorkoutViewHolder(View itemView) {
            super(itemView);
            workoutName = itemView.findViewById(R.id.tv_simple_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int index = getAdapterPosition();
            mOnClickListener.onWorkoutClicked(index);
        }
    }
}
