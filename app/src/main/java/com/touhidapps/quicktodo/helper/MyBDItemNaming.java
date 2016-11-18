package com.touhidapps.quicktodo.helper;



/**
 * Created by Touhid on 10/30/2016.
 */

public class MyBDItemNaming {

    interface Tables {
        String TODO_CATEGORY_LIST = "todo_category_list";
        String TODO_TASK_LIST = "todo_task_list";
    }

    interface TodoTaskCategoryTable {
        String CATEGORY_ID = "category_id";
        String CATEGORY_NAME = "category_name";
    }

    interface TodoTaskListTable {
        String TASK_ID = "task_id";
        String CATEGORY_ID = "category_id";
        String TASK_TITLE = "task_title";
        String TASK_DUE_DATE = "task_due_date";
        String TASK_NOTE = "task_note";
        String TASK_STATE = "task_state";
    }



}
