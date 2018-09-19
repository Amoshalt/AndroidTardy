package com.example.lomba.firstproject.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.lomba.firstproject.Model.Category;
import com.example.lomba.firstproject.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private Button categoryName;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.categoryName = itemView.findViewById(R.id.categoryName);
    }

    public void layoutForCategory(Category category){
        if(category != null){
            categoryName.setText(category.getName());
        }

    }


}
