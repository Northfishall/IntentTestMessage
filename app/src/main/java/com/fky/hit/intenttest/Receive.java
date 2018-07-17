package com.fky.hit.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Receive extends Activity {
    private TextView show;
    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.receive_main);
        show = (TextView) findViewById(R.id.show);
        Intent it = super.getIntent();
        String info = it.getStringExtra("myInfo");
        this.show.setText(info);
    }
}
