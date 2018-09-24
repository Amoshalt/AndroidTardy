package com.example.lomba.firstproject.ViewHolder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lomba.firstproject.Activities.MoviesActivity;
import com.example.lomba.firstproject.Interfaces.IItemOnCLickManager;
import com.example.lomba.firstproject.Model.Category;
import com.example.lomba.firstproject.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private Button categoryName;

    private IItemOnCLickManager mgr;

    public void setClickManager(IItemOnCLickManager mgr) {
        this.mgr = mgr;
    }

    public CategoryViewHolder(@NonNull final View itemView) {
        super(itemView);
        this.categoryName = itemView.findViewById(R.id.categoryName);

    }

    public void layoutForCategory(final Category category){
        if(category != null){
            categoryName.setText(category.getName());
        }

        itemView.setTag(category.getName());
        categoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mgr.OnClickItem(category.getName());
            }
        });
    }


}
