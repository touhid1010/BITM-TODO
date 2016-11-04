package com.touhidapps.quicktodo.todoList;

import java.util.ArrayList;

/**
 * Created by Touhid on 10/30/2016.
 */

public class TodoGroupList {

    private long id;
    private String name;
    private ArrayList<TodoTaskList> todoListTasks;

    public TodoGroupList(String name) {
        this.name = name;
    }

    public TodoGroupList(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TodoTaskList> getTodoListTasks() {
        return todoListTasks;
    }

    public void setTodoListTasks(ArrayList<TodoTaskList> todoListTasks) {
        this.todoListTasks = todoListTasks;
    }
}
