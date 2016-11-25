package com.touhidapps.quicktodo.customview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.touhidapps.quicktodo.R;
import com.touhidapps.quicktodo.commonitems.CommonNames;
import com.touhidapps.quicktodo.model.TodoCategory;
import com.touhidapps.quicktodo.model.TodoTask;
import com.touhidapps.quicktodo.view.AllTaskList;
import com.touhidapps.quicktodo.view.TaskDetails;

import java.util.List;

/**
 * Created by Touhid on 11/1/2016.
 */

public class MyRecyclerAdapterTask extends RecyclerView.Adapter<MyRecyclerViewHolderTask> {

    private List<TodoTask> todoTaskList;

    private Context context;
    private LayoutInflater inflater;
    MyRecyclerViewHolderTask viewHolder;

    public MyRecyclerAdapterTask(Context context, List<TodoTask> todoTaskList) {
        this.context = context;
        this.todoTaskList = todoTaskList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyRecyclerViewHolderTask onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.my_cardview_layout_for_task_list, parent, false);

        MyRecyclerViewHolderTask viewHolder1 = new MyRecyclerViewHolderTask(v);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(final MyRecyclerViewHolderTask holder, int position) {
        holder.textView_taskTitle.setText(todoTaskList.get(position).getTaskTitle());
        holder.textView_dateTime.setText("" + todoTaskList.get(position).getTaskDueDate() + " || " + todoTaskList.get(position).getTaskDueTime());
//        holder.imageView.setOnClickListener(this);
        holder.textView_taskTitle.setTag(todoTaskList.get(position).getTaskId()); // id for sql

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("touhidd", "onClick: " + holder.textView_taskTitle.getText());
//                Intent intent = new Intent(context, TaskDetails.class);
//                intent.putExtra(CommonNames.MY_INTENT_NAME_CONTAINS_GROUP_NAME, holder.textView_taskTitle.getTag().toString());
//                ((Activity) context).startActivity(intent);
                Toast.makeText(context, ""+holder.textView_taskTitle.getTag().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
//        return todoTaskList.size();
        return 0;
    }

}










