package com.example.bilal.myapp;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bilal on 15-Aug-17.
 */

public class EventDetail extends AppCompatActivity {


    TextView name, des, date, venu;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        name=(TextView) findViewById(R.id.name);
        des=(TextView)findViewById(R.id.des);
        date=(TextView)findViewById(R.id.date);
        venu=(TextView)findViewById(R.id.venue);
        pic=(ImageView)findViewById(R.id.pic);


        name.setText(getIntent().getExtras().getString("name"));
        date.setText(getIntent().getExtras().getString("date"));
        venu.setText(getIntent().getExtras().getString("venu"));
        des.setText(getIntent().getExtras().getString("des"));
      // pic.setImageResource(getIntent().getExtras().getIdentifier("hello"));
       String picName = getIntent().getExtras().getString("pic");
        Log.d("image",picName);
        Context c = getApplicationContext();
        int id = this.getResources().getIdentifier("drawable/"+picName, null, c.getPackageName());

         pic.setImageResource(id);

    }

    public static int getImageId(Context context, String imageName) {

        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    private Drawable resize(Drawable image) {
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(bitmap,
                (int) (bitmap.getWidth() * 0.5), (int) (bitmap.getHeight() * 0.5), false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }
    
}