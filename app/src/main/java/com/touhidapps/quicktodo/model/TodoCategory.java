package com.touhidapps.quicktodo.model;

import java.util.ArrayList;

/**
 * Created by Touhid on 11/7/2016.
 */

public class TodoCategory {

    private long categoryId;
    private String categoryName;
    private int itemCounterUnderCategory;

    public TodoCategory() {

    }

    public TodoCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public TodoCategory(long categoryId, String categoryName, int itemCounterUnderCategory) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.itemCounterUnderCategory = itemCounterUnderCategory;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getItemCounterUnderCategory() {
        return itemCounterUnderCategory;
    }

    public void setItemCounterUnderCategory(int itemCounterUnderCategory) {
        this.itemCounterUnderCategory = itemCounterUnderCategory;
    }
}
