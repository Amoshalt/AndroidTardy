package com.example.lomba.firstproject.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lomba.firstproject.Interfaces.IItemOnCLickManager;
import com.example.lomba.firstproject.Model.Category;
import com.example.lomba.firstproject.R;
import com.example.lomba.firstproject.ViewHolder.CategoryViewHolder;

import java.util.ArrayList;

public class CategoryAdpater extends RecyclerView.Adapter {

    private ArrayList<Category> categoriesList;

    private IItemOnCLickManager mgr;

    public void setClickManager(IItemOnCLickManager mgr) {
        this.mgr = mgr;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
        CategoryViewHolder vh = new CategoryViewHolder(mView);
        vh.setClickManager(mgr);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Category category = categoriesList.get(position);
        if(holder instanceof CategoryViewHolder && category != null){
            CategoryViewHolder viewHolder = (CategoryViewHolder) holder;
            viewHolder.layoutForCategory(category);
            viewHolder.setClickManager(mgr);
        }
    }

    @Override
    public int getItemCount() {
        if(categoriesList != null && categoriesList.size() != 0){
            return categoriesList.size();
        }
        return 0;
    }

    public void setCategoriesList(ArrayList<Category> categoriesList){
        this.categoriesList = categoriesList;
    }
}
