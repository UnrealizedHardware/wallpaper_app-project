package com.example.offlinewallpaperapp.wallpapers;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.offlinewallpaperapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Wallpapers extends AppCompatActivity {

    private final List<WallpapersList> wallpapersLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpapers);

        final ImageView backBtn = findViewById(R.id.back_btn);
        final TextView categoryName = findViewById(R.id.categoryName);
        final RecyclerView wallpapersRecyclerView = findViewById(R.id.WallpapersRecyclerView);

        final String getCategory = getIntent().getStringExtra("category");
        categoryName.setText(getCategory);

        wallpapersRecyclerView.setLayoutManager(new GridLayoutManager(Wallpapers.this, 2));
        wallpapersRecyclerView.setItemViewCacheSize(20);
        wallpapersRecyclerView.setDrawingCacheEnabled(true);


        AssetManager assetManager = getAssets();

        Context context;

        // Set up the new AlertDialog with a custom progress bar layout
        AlertDialog.Builder builder = new AlertDialog.Builder(Wallpapers.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.progress_dialog, null);
        builder.setView(dialogView);
        builder.setCancelable(false);
        AlertDialog progressDialog = builder.create();
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (getCategory.equals("Nature")) {

                        InputStream natureIs_1 = assetManager.open("nature1.jpg");
                        Bitmap natureImg1 = BitmapFactory.decodeStream(natureIs_1);

                         InputStream natureIs_2 = assetManager.open("nature2.jpg");
                        Bitmap natureImg2 = BitmapFactory.decodeStream(natureIs_2);

                        InputStream natureIs_3 = assetManager.open("nature3.jpg");
                        Bitmap natureImg3 = BitmapFactory.decodeStream(natureIs_3);

                        InputStream natureIs_4 = assetManager.open("nature4.jpg");
                        Bitmap natureImg4 = BitmapFactory.decodeStream(natureIs_4);

                        InputStream natureIs_5 = assetManager.open("nature5.jpg");
                        Bitmap natureImg5 = BitmapFactory.decodeStream(natureIs_5);

                        InputStream natureIs_6 = assetManager.open("nature6.jpg");
                        Bitmap natureImg6 = BitmapFactory.decodeStream(natureIs_6);

                        InputStream natureIs_7 = assetManager.open("nature7.jpg");
                        Bitmap natureImg7 = BitmapFactory.decodeStream(natureIs_7);

                        // add data to  list

                        WallpapersList natureList1 = new WallpapersList("nature1.jpg", natureImg1);
                        wallpapersLists.add(natureList1);

                        WallpapersList natureList2 = new WallpapersList("nature2.jpg", natureImg2);
                        wallpapersLists.add(natureList2);

                        WallpapersList natureList3 = new WallpapersList("nature3.jpg", natureImg3);
                        wallpapersLists.add(natureList3);

                        WallpapersList natureList4 = new WallpapersList("nature4.jpg", natureImg4);
                        wallpapersLists.add(natureList4);

                        WallpapersList natureList5 = new WallpapersList("nature5.jpg", natureImg5);
                        wallpapersLists.add(natureList5);

                        WallpapersList natureList6 = new WallpapersList("nature6.jpg", natureImg6);
                        wallpapersLists.add(natureList6);

                        WallpapersList natureList7 = new WallpapersList("nature7.jpg", natureImg7);
                        wallpapersLists.add(natureList7);

                } else if (getCategory.equals("Night")) {

                        InputStream nightIs_1 = assetManager.open("night1.jpg");
                        Bitmap nightImg1 = BitmapFactory.decodeStream(nightIs_1);

                        InputStream nightIs_2 = assetManager.open("night2.png");
                        Bitmap nightImg2 = BitmapFactory.decodeStream(nightIs_2);

                        WallpapersList nightList1 = new WallpapersList("night1.jpg", nightImg1);
                        wallpapersLists.add(nightList1);

                        WallpapersList nightList2 = new WallpapersList("night2.png", nightImg2);
                        wallpapersLists.add(nightList2);

                    } else if (getCategory.equals("Roads")) {


                        InputStream roadsIs1 = assetManager.open("roads1.jpg");
                        Bitmap roadsImg1 = BitmapFactory.decodeStream(roadsIs1);

                        InputStream roadsIs2= assetManager.open("roads2.jpg");
                        Bitmap roadsImg2 = BitmapFactory.decodeStream(roadsIs2);

                        InputStream roadsIs3 = assetManager.open("roads3.jpg");
                        Bitmap roadsImg3 = BitmapFactory.decodeStream(roadsIs3);

                        WallpapersList roadsList1 = new WallpapersList("roads1.jpg", roadsImg1);
                        wallpapersLists.add(roadsList1);

                        WallpapersList roadsList2 = new WallpapersList("roads2.jpg", roadsImg2);
                        wallpapersLists.add(roadsList2);

                        WallpapersList roadsList3 = new WallpapersList("roads3.jpg", roadsImg3);
                        wallpapersLists.add(roadsList3);
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();

                            wallpapersRecyclerView.setAdapter(new WallpapersAdapter(Wallpapers.this, wallpapersLists));
                        }
                    });
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}