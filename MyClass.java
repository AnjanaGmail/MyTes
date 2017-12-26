package com.example.admin.myapplication;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by admin on 12/24/2017.
 */

public class MyClass implements Serializable {
    private String name;
    private Bitmap image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyClass{");
        sb.append("name='").append(name).append('\'');
        sb.append(", image=").append(image);
        sb.append('}');
        return sb.toString();
    }
}
