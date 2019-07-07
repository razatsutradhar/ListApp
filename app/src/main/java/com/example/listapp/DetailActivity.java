package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
//this is an activity that will display the picture of each item on the list
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent in   = getIntent();                                                                  //get intent of this event from MainActivity
        int index = in.getExtras().getInt("com.example.listapp.itemIndex",-1);       //get the itemIndex we put for each list item

        if(index > -1){                                                                             //checks if the index exists
            int pic = getImg(index);                                                                //gets id of the image
            ImageView img = findViewById(R.id.imageView);                                           //gets the image view found in activity_detail
            scaleImage(img, pic);                                                                   //scales the image and sets it to the image view
        }
    }


    private int getImg(int in){                                                                     //given the index of the item in the list, get the picture index
        switch(in){
            case 0 : return R.drawable.peach;
            case 1 : return R.drawable.download;
            case 2 : return R.drawable.apple;
            default: return -1;
        }

    }

    private void scaleImage(ImageView view, int pic){                                               //scales the image if it is too big
        Display screen = getWindowManager().getDefaultDisplay();                                    //get the screen of the phone
        BitmapFactory.Options ops = new BitmapFactory.Options();                                    //open up the bitmap options

        ops.inJustDecodeBounds = true;                                                              ///set inJustDecodeBounds to true so we can get information on width
        BitmapFactory.decodeResource(getResources(), pic, ops);                                     //we decode the pic and relate it to the bitmap options
        int imgWidth = ops.outWidth;
        int screenWidth = screen.getWidth();                                                        //---- means outdated function but it still works

        if(imgWidth>screenWidth){
            int ratio = Math.round((float)imgWidth/(float)screenWidth);                             //make a ratio of how much bigger the image is
            ops.inSampleSize = ratio;                                                               //set the inSampleSize to the ratio to shrink the image
        }
        ops.inJustDecodeBounds = false;                                                             //we set inJustDecodeBounds to false just to de-op ourselves
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, ops);                  //we make a Bitmap to hold the scaled image
        view.setImageBitmap(scaledImg);                                                             //and we set the imageView to the new scaled image
    }
}
