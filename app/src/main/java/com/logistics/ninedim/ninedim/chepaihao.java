package com.logistics.ninedim.ninedim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by CZH on 2017/7/17.
 */

public class chepaihao extends Activity {

    private EditText EditText;
    private Button clearButton;
    private Button searchButton;

    public static final String chepaihao = "chepaihao";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chepaihao);

        EditText = (EditText) findViewById(R.id.dingdanzhuizong_dingdanhao);
        clearButton = (Button) findViewById(R.id.btn_dingdanqingkong);
        searchButton = (Button) findViewById(R.id.btn_dingdanchaxun);


        EditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText("");
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText("   请输入车牌号查询   ");
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(chepaihao.this,chepaihao_jsp.class);
                i.putExtra("info",EditText.getText().toString());
                startActivity(i);
            }
        });
    }

}
