package com.touhidapps.quicktodo.entity;

import java.util.ArrayList;

/**
 * Created by Touhid on 11/7/2016.
 */

public class TaskCategory {

    private long id;
    private String categoryName;
    private ArrayList<AllTask> allTasks;

    public TaskCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<AllTask> getAllTasks() {
        return allTasks;
    }

    public void setAllTasks(ArrayList<AllTask> allTasks) {
        this.allTasks = allTasks;
    }
}
