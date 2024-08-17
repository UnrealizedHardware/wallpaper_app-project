package com.example.offlinewallpaperapp;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.offlinewallpaperapp.categories.CategoriesAdapter;
import com.example.offlinewallpaperapp.categories.CategoriesList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<CategoriesList> categoriesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView);
        categoriesRecyclerView.setHasFixedSize(true);
//        categoriesRecyclerView.setAdapter();
        categoriesRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

        AssetManager assetManager = getAssets();

        try {
            InputStream natureIs = assetManager.open("nature1.jpg");
            Bitmap natureCategoryImg = BitmapFactory.decodeStream(natureIs);

            InputStream nighIs = assetManager.open("night1.jpg");
            Bitmap nightCategoryImg = BitmapFactory.decodeStream(nighIs);

            InputStream roadsIs = assetManager.open("roads1.jpg");
            Bitmap roadsCategoryImg = BitmapFactory.decodeStream(roadsIs);

            CategoriesList natureCategory = new CategoriesList("Nature", natureCategoryImg);
            categoriesList.add(natureCategory);

            CategoriesList nightCategory = new CategoriesList("Night", nightCategoryImg);
            categoriesList.add(nightCategory);

            CategoriesList roadsCategory = new CategoriesList("Roads", roadsCategoryImg);
            categoriesList.add(roadsCategory);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CategoriesAdapter categoryAdapter = new CategoriesAdapter(this,categoriesList);
        categoriesRecyclerView.setAdapter(categoryAdapter);
    };
}