package com.touhidapps.quicktodo.helper;

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

    private String db_table_todoList_group_query = "CREATE TABLE " + MyBDItemNaming.Tables.TODO_CATEGORY_LIST + " ("
            + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MyBDItemNaming.TodoTaskCategoryTable.CATEGORY_NAME + " TEXT NOT NULL)";

    private String db_table_todoList_task_query = "CREATE TABLE " + MyBDItemNaming.Tables.TODO_TASK_LIST + " ("
            + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MyBDItemNaming.TodoTaskListTable.TASK_ID + " TEXT,"
            + MyBDItemNaming.TodoTaskListTable.CATEGORY_ID + " INTEGER,"
            + MyBDItemNaming.TodoTaskListTable.TASK_TITLE + " TEXT,"
            + MyBDItemNaming.TodoTaskListTable.TASK_DUE_DATE + " TEXT,"
            + MyBDItemNaming.TodoTaskListTable.TASK_DUE_TIME + " TEXT,"
            + MyBDItemNaming.TodoTaskListTable.TASK_REMINDER_DATE + " TEXT,"
            + MyBDItemNaming.TodoTaskListTable.TASK_REMINDER_TIME + " TEXT,"
            + MyBDItemNaming.TodoTaskListTable.TASK_NOTE + " TEXT,"
            + MyBDItemNaming.TodoTaskListTable.TASK_STATE + " TEXT," +
            "FOREIGN KEY (" + MyBDItemNaming.TodoTaskListTable.CATEGORY_ID +
            ") REFERENCES " + MyBDItemNaming.Tables.TODO_CATEGORY_LIST + "(" + BaseColumns._ID + "))";

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
        db.execSQL("DROP TABLE IF EXISTS " + MyBDItemNaming.Tables.TODO_CATEGORY_LIST);
        db.execSQL("DROP TABLE IF EXISTS " + MyBDItemNaming.Tables.TODO_TASK_LIST);
        onCreate(db);
    }

}
