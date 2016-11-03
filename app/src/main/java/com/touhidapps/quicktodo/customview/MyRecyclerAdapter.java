package com.touhidapps.quicktodo.customview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.touhidapps.quicktodo.R;
import com.touhidapps.quicktodo.todoList.TodoGroupList;

import java.util.ArrayList;

/**
 * Created by Touhid on 11/1/2016.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> implements View.OnClickListener {

    ArrayList<TodoGroupList> name;

    Context context;
    LayoutInflater inflater;
    public MyRecyclerAdapter(Context context, ArrayList<TodoGroupList> name) {
        this.context = context;
        this.name = name;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.my_cardview_layout_for_task_group_list, parent, false);

        MyRecyclerViewHolder viewHolder = new MyRecyclerViewHolder(v);
        v.setOnClickListener(this);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        holder.tv1.setText(name.get(position).getName());
//        holder.imageView.setOnClickListener(clickListener);
        holder.imageView.setTag(holder);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    @Override
    public void onClick(View view) {

        // TODO
        Toast.makeText(context, "This is position " + view.getId(), Toast.LENGTH_LONG).show();

    }
}
