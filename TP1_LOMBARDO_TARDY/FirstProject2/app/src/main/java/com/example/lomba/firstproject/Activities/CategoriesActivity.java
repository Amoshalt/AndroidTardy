package com.example.lomba.firstproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.LogPrinter;

import com.example.lomba.firstproject.Adapter.CategoryAdpater;
import com.example.lomba.firstproject.Interfaces.IItemOnCLickManager;
import com.example.lomba.firstproject.Model.Category;
import com.example.lomba.firstproject.R;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CategoriesActivity extends AppCompatActivity implements IItemOnCLickManager {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);
        CategoryAdpater catAdapter = new CategoryAdpater();
        catAdapter.setCategoriesList(this.setCategoriesList());
        this.mRecyclerView = findViewById(R.id.main_recycler_view);
        catAdapter.setClickManager(this);
        this.mRecyclerView.setAdapter(catAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public ArrayList<Category> setCategoriesList (){
        ArrayList<Category> categoriesList = new ArrayList<>();
        categoriesList.add(Category.TOUTES);
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

        return categoriesList;
    };

    @Override
    public void OnClickItem(Object object) {
        String catName = (String) object;
        Log.d("test", "catName == 'TOUTES'");
        if (catName == "TOUTES"){
            Log.d("test2", "catName == 'TOUTES'");
        }

        Intent i = new Intent(this, MoviesActivity.class);
        startActivity(i);
    }

}
