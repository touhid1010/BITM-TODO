package com.touhidapps.quicktodo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Touhid on 10/28/2016.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String TAG = MyDBHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "todoList.db";
    private static final int DATABASE_VERSION = 1;
    private final Context mContext;

    private String db_table_todoList_group_query = "CREATE TABLE " + MyBDItemNaming.Tables.TODO_LIST_GROUP + " ("
            + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MyBDItemNaming.TodoList_group_Columns.GROUP_NAME + " TEXT NOT NULL)";

    private String db_table_todoList_task_query = "CREATE TABLE " + MyBDItemNaming.Tables.TODO_LIST_TASK + " ("
            + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MyBDItemNaming.TodoList_task_Columns.GROUP_ID + " TEXT,"
            + MyBDItemNaming.TodoList_task_Columns.TASK_TITLE + " TEXT,"
            + MyBDItemNaming.TodoList_task_Columns.TASK_DUE_DATE + " TEXT,"
            + MyBDItemNaming.TodoList_task_Columns.TASK_NOTE + " TEXT,"
            + MyBDItemNaming.TodoList_task_Columns.TASK_CURRENT_STATE + " TEXT)";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_table_todoList_group_query);
        db.execSQL(db_table_todoList_task_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MyBDItemNaming.Tables.TODO_LIST_GROUP);
        db.execSQL("DROP TABLE IF EXISTS " + MyBDItemNaming.Tables.TODO_LIST_TASK);
        onCreate(db);
    }
}
