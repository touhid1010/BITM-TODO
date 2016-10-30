package com.touhidapps.quicktodo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.touhidapps.quicktodo.todoList.TodoListGroup;

import java.util.ArrayList;

import static com.touhidapps.quicktodo.database.MyBDItemNaming.TodoList_group_Columns.GROUP_NAME;

/**
 * Created by Touhid on 10/28/2016.
 */

public class MyTaskGroup {

    private MyDBHelper mOpenHelper;
    private Context mContext;
    private SQLiteDatabase sqLiteDatabase;

    public MyTaskGroup(Context context){
        mContext = context;
        mOpenHelper = new MyDBHelper(mContext);
    }

    public long addTodoListGroup(TodoListGroup todoListGroup){
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyBDItemNaming.TodoList_group_Columns.GROUP_NAME, todoListGroup.getName());
        long data = sqLiteDatabase.insert(MyBDItemNaming.Tables.TODO_LIST_GROUP, null, contentValues);
        sqLiteDatabase.close();
        return data;
    }

    public ArrayList<TodoListGroup> getAllTodoListGroup(){

        sqLiteDatabase = mOpenHelper.getReadableDatabase();
        ArrayList<TodoListGroup> todoListGroups = new ArrayList<>();
        String todoListGroupQuery = "select * from " + MyBDItemNaming.Tables.TODO_LIST_GROUP;
        Cursor cursor = sqLiteDatabase.rawQuery(todoListGroupQuery, null);
        TodoListGroup todoListGroup;
        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyBDItemNaming.TodoList_group_Columns.GROUP_ID));
                String name = cursor.getString(cursor.getColumnIndex(GROUP_NAME));
                todoListGroup = new TodoListGroup(id, name);
                todoListGroups.add(todoListGroup);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return todoListGroups;
    }

    public long updateTodoListGroup(TodoListGroup todoListGroup){
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyBDItemNaming.TodoList_group_Columns.GROUP_ID, todoListGroup.getId());
        contentValues.put(MyBDItemNaming.TodoList_group_Columns.GROUP_NAME, todoListGroup.getName());
        long result = sqLiteDatabase.update(MyBDItemNaming.Tables.TODO_LIST_GROUP,contentValues,
                MyBDItemNaming.TodoList_group_Columns.GROUP_ID +"=?",
                new String[]{String.valueOf(todoListGroup.getId())});
        sqLiteDatabase.close();
        return result;
    }

    public long deleteTodoListGroup(long id){
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
        long result = sqLiteDatabase.delete(MyBDItemNaming.Tables.TODO_LIST_GROUP,
                MyBDItemNaming.TodoList_group_Columns.GROUP_ID +"=?",
                new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return result;
    }

}
