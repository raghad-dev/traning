package com.example.training;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView mImaeView;
    TextView mTitle;
   ItemClickListener itemClickListener;

    holder(@NonNull View itemView) {
        super(itemView);


itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});
        this.mImaeView = itemView.findViewById(R.id.imageView11);
        this.mTitle = itemView.findViewById(R.id.titleTv);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    this.itemClickListener.onItemClickListener(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener =ic;


    }
}
