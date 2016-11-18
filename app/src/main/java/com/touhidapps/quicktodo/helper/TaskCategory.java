package com.touhidapps.quicktodo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.touhidapps.quicktodo.model.TodoCategory;
import com.touhidapps.quicktodo.todoList.TodoCategoryList;
import com.touhidapps.quicktodo.todoList.TodoGroupList;

import java.util.ArrayList;

import static com.touhidapps.quicktodo.helper.MyBDItemNaming.TodoList_group_Columns.GROUP_NAME;

/**
 * Created by Touhid on 10/28/2016.
 */

public class TaskCategory {

    private MyDBHelper mOpenHelper;
    private Context mContext;
    private SQLiteDatabase sqLiteDatabase;

    public TaskCategory(Context context) {
        mContext = context;
        mOpenHelper = new MyDBHelper(mContext);
    }

    public long addTaskCategory(TodoCategory todoCategory) {
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyBDItemNaming.TodoTaskCategoryTable.CATEGORY_NAME, todoCategory.getCategoryName());
        long data = sqLiteDatabase.insert(MyBDItemNaming.Tables.TODO_CATEGORY_LIST, null, contentValues);
        sqLiteDatabase.close();
        return data;
    }

    public ArrayList<TodoCategoryList> getAllTodoListGroup() {

        sqLiteDatabase = mOpenHelper.getReadableDatabase();
        ArrayList<TodoCategoryList> todoListGroups = new ArrayList<>();
        String todoListGroupQuery = "select * from " + MyBDItemNaming.Tables.TODO_LIST_GROUP;
        Cursor cursor = sqLiteDatabase.rawQuery(todoListGroupQuery, null);
        TodoCategoryList todoListGroup;
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyBDItemNaming.TodoList_group_Columns.GROUP_ID));
                String name = cursor.getString(cursor.getColumnIndex(GROUP_NAME));
                todoListGroup = new TodoCategoryList(id, name);
                todoListGroups.add(todoListGroup);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return todoListGroups;
    }

    public long updateTodoListGroup(TodoCategoryList todoCategoryList) {
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyBDItemNaming.TodoList_group_Columns.GROUP_ID, todoCategoryList.getId());
        contentValues.put(MyBDItemNaming.TodoList_group_Columns.GROUP_NAME, todoCategoryList.getName());
        long result = sqLiteDatabase.update(MyBDItemNaming.Tables.TODO_LIST_GROUP, contentValues,
                MyBDItemNaming.TodoList_group_Columns.GROUP_ID + "=?",
                new String[]{String.valueOf(todoCategoryList.getId())});
        sqLiteDatabase.close();
        return result;
    }

    public long deleteTodoListGroup(long id) {
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
        long result = sqLiteDatabase.delete(MyBDItemNaming.Tables.TODO_LIST_GROUP,
                MyBDItemNaming.TodoList_group_Columns.GROUP_ID + "=?",
                new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return result;
    }

}
