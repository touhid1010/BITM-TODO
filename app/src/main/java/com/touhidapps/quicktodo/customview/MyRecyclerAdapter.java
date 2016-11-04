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
import com.touhidapps.quicktodo.todoList.AllTaskList;
import com.touhidapps.quicktodo.todoList.TodoGroupList;


import java.util.ArrayList;

/**
 * Created by Touhid on 11/1/2016.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

    ArrayList<TodoGroupList> nameAndId;

    Context context;
    LayoutInflater inflater;
    MyRecyclerViewHolder viewHolder;

    public MyRecyclerAdapter(Context context, ArrayList<TodoGroupList> nameAndId) {
        this.context = context;
        this.nameAndId = nameAndId;
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
        holder.tv1.setText(nameAndId.get(position).getName());
//        holder.imageView.setOnClickListener(this);
//        holder.tv1.setTag(holder);
        holder.tv1.setTag(nameAndId.get(position).getName());

        holder.overflowimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("touhidd", "onClick: "+holder.tv1.getText());
                Intent intent = new Intent(context, AllTaskList.class);
                intent.putExtra(CommonNames.MY_INTENT_NAME_CONTAINS_GROUP_NAME, holder.tv1.getText().toString());
                ((Activity)context).startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nameAndId.size();
    }

}










