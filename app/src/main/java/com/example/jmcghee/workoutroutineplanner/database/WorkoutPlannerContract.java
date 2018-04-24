package com.example.jmcghee.workoutroutineplanner.database;

import android.provider.BaseColumns;

public class WorkoutPlannerContract {

    public static final class workout implements BaseColumns {
        public static final String TABLE_NAME = "workout";
        public static final String COLUMN_NAME = "name";
    }

    public static final class workoutSection implements BaseColumns {
        public static final String TABLE_NAME = "workout";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_WORKOUT_ID = "workout_id";
    }

    public static final class exercise implements BaseColumns {
        public static final String TABLE_NAME = "exercise";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_WORKOUT_SECTION_ID = "workout_section_id";
        public static final String COLUMN_SETS = "sets";
        public static final String COLUMN_IS_ISOMETRIC = "is_isometric";
        public static final String COLUMN_REPS = "reps";
        public static final String COLUMN_HOLD_TIME = "hold_time";
    }

}
