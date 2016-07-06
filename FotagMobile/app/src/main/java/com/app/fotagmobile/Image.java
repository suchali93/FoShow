package com.app.fotagmobile;

import android.graphics.Bitmap;

public class Image {
    private Bitmap image;
    private float rating;

    public Image(Bitmap image, float rating) {
        super();
        this.image = image;
        this.rating = rating;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public float getRatingStar() {
        return rating;
    }

    public void setRatingStar(float rating) {
        this.rating = rating;
    }
}