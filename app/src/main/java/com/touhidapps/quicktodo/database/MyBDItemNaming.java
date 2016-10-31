package com.touhidapps.quicktodo.database;



/**
 * Created by Touhid on 10/30/2016.
 */

public class MyBDItemNaming {

    interface Tables {
        String TODO_LIST_GROUP = "todoList_group";
        String TODO_LIST_TASK = "todoList_task";
    }

    interface TodoList_group_Columns {
        String GROUP_ID = "_id";
        String GROUP_NAME = "group_name";
    }

    interface TodoList_task_Columns {
        String TASK_ID = "_id";
        String GROUP_ID = "group_id";
        String TASK_TITLE = "task_title";
        String TASK_DUE_DATE = "task_date";
        String TASK_NOTE = "task_note";
        String TASK_CURRENT_STATE = "task_current_state";
    }



}
