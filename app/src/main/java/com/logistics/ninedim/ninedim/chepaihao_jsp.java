package com.logistics.ninedim.ninedim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by CZH on 2017/7/17.
 */
public class  chepaihao_jsp extends Activity {
    private Button mButton;
    private TextView mTextView;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        mButton = (Button) findViewById(R.id.myButton);
        mTextView = (TextView) findViewById(R.id.textView);
        mButton.setOnClickListener(new MyOnClickListener());



        Intent i = getIntent();
        final String para = i.getStringExtra("info");
        mTextView.setText(HttpUtils.submitPostData(para, "utf-8"));
    }

    private class MyOnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
}