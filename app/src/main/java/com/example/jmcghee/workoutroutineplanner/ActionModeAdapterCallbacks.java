package com.example.jmcghee.workoutroutineplanner;

import java.util.List;

public interface ActionModeAdapterCallbacks<T> {

    void toggleSelection(int position);
    void clearSelections();
    int getSelectedCount();
    List<T> getSelectedItems();

}
