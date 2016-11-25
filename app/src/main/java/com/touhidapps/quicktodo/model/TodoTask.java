package com.touhidapps.quicktodo.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Touhid on 11/7/2016.
 */

public class TodoTask {

    private long taskId;
    private long categoryId;
    private String taskTitle;
    private Date taskDueDate;
    private Time taskDueTime;
    private Date taskReminderDate;
    private Time taskReminderTime;
    private String taskNote;
    private boolean taskState;

    public TodoTask() {

    }

    public TodoTask(long taskId) {
        this.taskId = taskId;
    }

    public TodoTask(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Date getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(Date taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public Time getTaskDueTime() {
        return taskDueTime;
    }

    public void setTaskDueTime(Time taskDueTime) {
        this.taskDueTime = taskDueTime;
    }

    public Date getTaskReminderDate() {
        return taskReminderDate;
    }

    public void setTaskReminderDate(Date taskReminderDate) {
        this.taskReminderDate = taskReminderDate;
    }

    public Time getTaskReminderTime() {
        return taskReminderTime;
    }

    public void setTaskReminderTime(Time taskReminderTime) {
        this.taskReminderTime = taskReminderTime;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public boolean isTaskState() {
        return taskState;
    }

    public void setTaskState(boolean taskState) {
        this.taskState = taskState;
    }
}
