package com.fky.hit.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Send extends AppCompatActivity {
    private Button myBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_main);
        myBut = findViewById(R.id.myBut);
        myBut.setOnClickListener(new OnClickListenerlmpl());
    }

    private class OnClickListenerlmpl implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Intent it = new Intent(Send.this,Receive.class);
            it.putExtra("myInfo","AndroidTest");
            Send.this.startActivity(it);
        }
    }
}
