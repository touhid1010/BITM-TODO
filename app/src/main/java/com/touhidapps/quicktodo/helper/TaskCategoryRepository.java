package com.touhidapps.quicktodo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.touhidapps.quicktodo.model.TodoCategory;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Touhid on 10/28/2016.
 */

public class TaskCategoryRepository {

    private MyDBHelper mOpenHelper;
    private Context mContext;
    private SQLiteDatabase sqLiteDatabase;

    public TaskCategoryRepository(Context context) {
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

    public List<TodoCategory> getAllCategories() {
        sqLiteDatabase = mOpenHelper.getReadableDatabase();
        List<TodoCategory> todoCategoryList = new ArrayList<>();
        String todoListGroupQuery = "SELECT * FROM " + MyBDItemNaming.Tables.TODO_CATEGORY_LIST;
        Cursor cursor = sqLiteDatabase.rawQuery(todoListGroupQuery, null);

        if (cursor.moveToFirst()) {
            do {

                long id = Long.parseLong(cursor.getString(0)); // id convert to long from string
                String name = cursor.getString(1);
                int amount = countTaskUnderCategory(id); // this counted data do not come from this cursor , come from another cursor

                todoCategoryList.add(new TodoCategory(id, name, amount));

            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return todoCategoryList;
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

    public int countTaskUnderCategory(long catId) {
        sqLiteDatabase = mOpenHelper.getReadableDatabase();
        String itemsInCategory = "SELECT COUNT(*) FROM " + MyBDItemNaming.Tables.TODO_TASK_LIST +
                " WHERE " + MyBDItemNaming.TodoTaskListTable.CATEGORY_ID + " = '" + catId + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(itemsInCategory, null);
        cursor.moveToFirst();
        int i = cursor.getInt(0);
        cursor.close();
        return i;
    }

    public int countTaskStatusUnderCategory(String statusId) {   // statusId "0" means inactive and "1" means active task
        sqLiteDatabase = mOpenHelper.getReadableDatabase();
        String itemsInCategory = "SELECT COUNT(*) FROM " + MyBDItemNaming.Tables.TODO_TASK_LIST + " WHERE " +
                MyBDItemNaming.TodoTaskListTable.TASK_STATE + " = '" + statusId + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(itemsInCategory, null);
        cursor.moveToFirst();
        int i = cursor.getInt(0);
        cursor.close();
        return i;
    }


}
