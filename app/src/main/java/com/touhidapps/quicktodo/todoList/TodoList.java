package com.touhidapps.quicktodo.todoList;

import java.util.ArrayList;

/**
 * Created by Touhid on 10/30/2016.
 */

public class TodoList {

    private ArrayList<TodoGroupList> todoGroupList;

    public ArrayList<TodoGroupList> getTodoListGroups() {
        return todoGroupList;
    }

    public void setTodoListGroups(ArrayList<TodoGroupList> todoListGroups) {
        this.todoGroupList = todoGroupList;
    }
}
