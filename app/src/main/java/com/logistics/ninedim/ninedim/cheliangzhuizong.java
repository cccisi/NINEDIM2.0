package com.logistics.ninedim.ninedim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by CZH on 2017/7/17.
 */

public class cheliangzhuizong extends Activity {

    Button chepaihaochaxun;
    Button zhanghuhaochaxun;
    Button cheduichaxun;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheliangzhuizong);
        chepaihaochaxun = (Button) findViewById(R.id.btn_chepaihaochaxun);
        zhanghuhaochaxun = (Button) findViewById(R.id.btn_zhanghuhaochaxun);
        cheduichaxun = (Button) findViewById(R.id.btn_cheduichaxun);

        chepaihaochaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cheliangzhuizong.this, chepaihao.class);
                startActivity(intent);
            }
        });

        zhanghuhaochaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cheliangzhuizong.this, zhanghuhao.class);
                startActivity(intent);
            }
        });

        cheduichaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cheliangzhuizong.this, cheduichaxun.class);
                startActivity(intent);
            }
        });



    }
}
