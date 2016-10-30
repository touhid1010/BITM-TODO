package com.touhidapps.quicktodo.todoList;

import java.util.ArrayList;

/**
 * Created by Touhid on 10/30/2016.
 */

public class TodoList {

    private ArrayList<TodoListGroup> todoListGroups;

    public ArrayList<TodoListGroup> getTodoListGroups() {
        return todoListGroups;
    }

    public void setTodoListGroups(ArrayList<TodoListGroup> todoListGroups) {
        this.todoListGroups = todoListGroups;
    }
}
