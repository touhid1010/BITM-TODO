package com.touhidapps.quicktodo.model;

import java.util.ArrayList;

/**
 * Created by Touhid on 11/7/2016.
 */

public class TodoCategory {

    private long categoryId;
    private String categoryName;

    public TodoCategory() {

    }

    public TodoCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public TodoCategory(long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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
}
