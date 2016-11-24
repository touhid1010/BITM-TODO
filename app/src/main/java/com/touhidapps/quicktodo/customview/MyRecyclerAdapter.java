package com.touhidapps.quicktodo.customview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touhidapps.quicktodo.R;
import com.touhidapps.quicktodo.commonitems.CommonNames;
import com.touhidapps.quicktodo.model.TodoCategory;
import com.touhidapps.quicktodo.view.AllTaskList;


import java.util.List;

/**
 * Created by Touhid on 11/1/2016.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

    private List<TodoCategory> todoCategoryList;

    private Context context;
    private LayoutInflater inflater;
    MyRecyclerViewHolder viewHolder;

    public MyRecyclerAdapter(Context context, List<TodoCategory> todoCategoryList) {
        this.context = context;
        this.todoCategoryList = todoCategoryList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.my_cardview_layout_for_task_group_list, parent, false);

        MyRecyclerViewHolder viewHolder1 = new MyRecyclerViewHolder(v);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(final MyRecyclerViewHolder holder, int position) {
        holder.tv1.setText(todoCategoryList.get(position).getCategoryName());
        holder.textView_amount.setText("" + todoCategoryList.get(position).getItemCounterUnderCategory());
//        holder.imageView.setOnClickListener(this);
//        holder.tv1.setTag(holder);
        holder.tv1.setTag(todoCategoryList.get(position).getCategoryName());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("touhidd", "onClick: " + holder.tv1.getText());
                Intent intent = new Intent(context, AllTaskList.class);
                intent.putExtra(CommonNames.MY_INTENT_NAME_CONTAINS_GROUP_NAME, holder.tv1.getText().toString());
                ((Activity) context).startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoCategoryList.size();
    }

}










