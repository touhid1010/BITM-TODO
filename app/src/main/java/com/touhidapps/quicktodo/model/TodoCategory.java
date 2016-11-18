package com.touhidapps.quicktodo.model;

import java.util.ArrayList;

/**
 * Created by Touhid on 11/7/2016.
 */

public class TodoCategory {

    private long category_id;
    private String categoryName;

    public TodoCategory() {

    }

    public TodoCategory(long category_id) {
        this.category_id = category_id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
