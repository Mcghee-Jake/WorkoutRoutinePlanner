package com.example.jmcghee.workoutroutineplanner;

import java.util.List;

public interface ActionModeAdapterCallbacks{

    void toggleSelection(int position);

    void clearSelections();

    int getSelectedCount();

}
