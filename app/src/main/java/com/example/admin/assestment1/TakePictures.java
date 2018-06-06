package com.example.admin.assestment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class TakePictures extends AppCompatActivity {

    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_pictures);
        pic = findViewById(R.id.Iv_picture);
        Bitmap photo = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra(Constants.TAKEN_PIC), 0, getIntent().getByteArrayExtra(Constants.TAKEN_PIC).length);
        pic.setImageBitmap(photo);
    }

}
