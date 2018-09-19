package com.example.lomba.firstproject.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lomba.firstproject.Adapter.CategoryAdpater;
import com.example.lomba.firstproject.Model.Category;
import com.example.lomba.firstproject.R;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);
        CategoryAdpater catAdapter = new CategoryAdpater();
        catAdapter.setCategoriesList(this.setCategoriesList());
        this.mRecyclerView = findViewById(R.id.main_recycler_view);
        this.mRecyclerView.setAdapter(catAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public ArrayList<Category> setCategoriesList (){
        ArrayList<Category> categoriesList = new ArrayList<>();
        categoriesList.add(Category.HUMOUR);
        categoriesList.add(Category.HORREUR);
        categoriesList.add(Category.ROMANCE);
        categoriesList.add(Category.COMEDIE);
        categoriesList.add(Category.ACTION);
        categoriesList.add(Category.AVENTURE);
        categoriesList.add(Category.GUERRE);
        categoriesList.add(Category.DOCUMENTAIRES);
        categoriesList.add(Category.POLICIER);
        categoriesList.add(Category.SCIENCEFICTION);
        categoriesList.add(Category.WESTERN);
        categoriesList.add(Category.BIOPIC);
        categoriesList.add(Category.MANGAS);
        categoriesList.add(Category.ANIMATION);
        categoriesList.add(Category.COMEDIEM);
        categoriesList.add(Category.TOUTES);

        return categoriesList;
    };

}
