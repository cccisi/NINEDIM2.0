package com.logistics.ninedim.ninedim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by CZH on 2017/7/17.
 */

public class dingdanzhuizong extends Activity {
    EditText EditText;
    Button clearButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dingdanzhuizong);
        EditText = (EditText) findViewById(R.id.dingdanzhuizong_dingdanhao);
        clearButton = (Button) findViewById(R.id.btn_dingdanqingkong);

        EditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText("");
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText("   请输入订单号查询   ");
            }
        });
    }

}

