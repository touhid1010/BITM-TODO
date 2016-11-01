package com.touhidapps.quicktodo.customview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

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
        View v = inflater.inflate(R.layout.my_cardview_layout, parent, false);

        MyRecyclerViewHolder viewHolder = new MyRecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        holder.tv1.setText(name.get(position).getName());
        holder.imageView.setOnClickListener(clickListener);
        holder.imageView.setTag(holder);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MyRecyclerViewHolder vholder = (MyRecyclerViewHolder) v.getTag();
            int position = vholder.getLayoutPosition();

            Toast.makeText(context, "This is position " + position, Toast.LENGTH_LONG).show();

        }
    };


}
