package com.touhidapps.quicktodo.customview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.touhidapps.quicktodo.R;

/**
 * Created by Touhid on 11/1/2016.
 */

public class MyRecyclerViewHolderTask extends RecyclerView.ViewHolder {

    TextView textView_taskTitle, textView_dateTime;
    ImageView imageView;
    CardView card_view;

    public MyRecyclerViewHolderTask(View itemView) {
        super(itemView);
        textView_taskTitle = (TextView) itemView.findViewById(R.id.textView_taskTitle);
        textView_dateTime = (TextView) itemView.findViewById(R.id.textView_dateTime);
        imageView = (ImageView) itemView.findViewById(R.id.list_avatar);
        card_view = (CardView) itemView.findViewById(R.id.card_view);
    }
}
