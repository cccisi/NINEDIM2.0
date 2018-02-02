package com.logistics.ninedim.ninedim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView Img_dingdanzhuizong;
    ImageView Img_yundanzhuizong;
    ImageView Img_cheliangzhuizong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
//        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlecenter);

//        TextView view = (TextView) findViewById(android.R.id.title);
//        view.setGravity(0);

        Img_dingdanzhuizong = (ImageView) findViewById(R.id.photo1);
        Img_yundanzhuizong = (ImageView) findViewById(R.id.photo2);
        Img_cheliangzhuizong = (ImageView) findViewById(R.id.photo3);

        Img_dingdanzhuizong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, dingdanzhuizong.class);
                startActivity(intent);
            }
        });

        Img_yundanzhuizong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, yundanzhuizong.class);
                startActivity(intent);
            }
        });

        Img_cheliangzhuizong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cheliangzhuizong.class);
                startActivity(intent);
            }
        });


    }
}
