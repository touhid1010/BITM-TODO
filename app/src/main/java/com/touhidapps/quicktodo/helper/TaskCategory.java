package com.touhidapps.quicktodo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.touhidapps.quicktodo.model.TodoCategory;


import java.util.ArrayList;


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

    public ArrayList<TodoCategory> getAllTodoListGroup() {

        sqLiteDatabase = mOpenHelper.getReadableDatabase();
        ArrayList<TodoCategory> todoListGroups = new ArrayList<>();
        String todoListGroupQuery = "select * from " + MyBDItemNaming.Tables.TODO_CATEGORY_LIST;
        Cursor cursor = sqLiteDatabase.rawQuery(todoListGroupQuery, null);
        TodoCategory todoListGroup;
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyBDItemNaming.TodoTaskCategoryTable.CATEGORY_ID));
                String name = cursor.getString(cursor.getColumnIndex("GROUP_NAME"));
                todoListGroup = new TodoCategory(id, name);
                todoListGroups.add(todoListGroup);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return todoListGroups;
    }

    public long updateTodoListGroup(TodoCategory todoCategory) {
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyBDItemNaming.TodoTaskCategoryTable.CATEGORY_ID, todoCategory.getCategoryId());
        contentValues.put(MyBDItemNaming.TodoTaskCategoryTable.CATEGORY_NAME, todoCategory.getCategoryName());
        long result = sqLiteDatabase.update(MyBDItemNaming.Tables.TODO_CATEGORY_LIST, contentValues,
                MyBDItemNaming.TodoTaskCategoryTable.CATEGORY_ID + "=?",
                new String[]{String.valueOf(todoCategory.getCategoryId())});
        sqLiteDatabase.close();
        return result;
    }

    public long deleteTodoListGroup(long id) {
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
        long result = sqLiteDatabase.delete(MyBDItemNaming.Tables.TODO_CATEGORY_LIST,
                MyBDItemNaming.TodoTaskCategoryTable.CATEGORY_ID + "=?",
                new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return result;
    }

}
