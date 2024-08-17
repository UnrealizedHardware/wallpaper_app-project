package com.example.offlinewallpaperapp.wallpapers;

import android.graphics.Bitmap;

public class WallpapersList {

    private String filename;
    private Bitmap bitmap;

    public WallpapersList(String filename, Bitmap bitmap) {
        this.filename = filename;
        this.bitmap = bitmap;
    }

    public String getFilename() {
        return filename;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
