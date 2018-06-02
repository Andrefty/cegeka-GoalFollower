package com.example.cristi.firstcegeka;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailActivity_Image extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__image);

       Intent in = getIntent();
        int index = in.getIntExtra("com.example.cristi.firstcegeka.Item" , -1);
       Toast.makeText(this, index + "" , Toast.LENGTH_LONG).show();

        if (index >-1 )
        {
           int pic = SeekImg(index);

            ImageView img = (ImageView) findViewById(R.id.imageView);

            Scale(img , pic);

        }

    }

    private  int SeekImg (int index)
    {
        switch (index)
        {
            case 0 : return R.drawable.robotboi;

            case 1 : return R.drawable.d;

            case 2 : return R.drawable.chites_bot;

            default: return -1;
        }
    }

    private void Scale (ImageView ImgV , int pic)
    {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources() , pic , options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth)
        {
            int ratio = Math.round((float) imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;

        Bitmap scaledImg = BitmapFactory.decodeResource(getResources() , pic , options);
        ImgV.setImageBitmap(scaledImg);
    }

}
