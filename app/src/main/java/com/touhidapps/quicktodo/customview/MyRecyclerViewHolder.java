package com.touhidapps.quicktodo.customview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.touhidapps.quicktodo.R;

/**
 * Created by Touhid on 11/1/2016.
 */

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tv1, tv2;
    ImageView imageView;
    CardView card_view;

    public MyRecyclerViewHolder(View itemView) {
        super(itemView);
        tv1 = (TextView) itemView.findViewById(R.id.list_title);
        tv2 = (TextView) itemView.findViewById(R.id.list_desc);
        imageView = (ImageView) itemView.findViewById(R.id.list_avatar);
        card_view = (CardView) itemView.findViewById(R.id.card_view);
    }
}
