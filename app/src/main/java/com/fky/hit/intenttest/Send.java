package com.fky.hit.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Send extends Activity {
    private Button myBut;
    private Button GoNet;
    private TextView msg;
    private EditText NetUrlE;
    private String NetUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.send_main);
        myBut = findViewById(R.id.myBut);
        msg= findViewById(R.id.msg);
        GoNet = findViewById(R.id.GoNet);
        NetUrlE = findViewById(R.id.NetUrl);
        NetUrl = NetUrlE.getText().toString();
        Toast.makeText(this, NetUrl, Toast.LENGTH_SHORT).show();
        myBut.setOnClickListener(new OnClickListenerlmpl());
        GoNet.setOnClickListener(new OnClickListenerNetWord());
    }

    private class OnClickListenerNetWord implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Uri uri = Uri.parse("https://"+NetUrl);
            Intent it = new Intent();
            it.setAction(Intent.ACTION_VIEW);
            it.setData(uri);
            Send.this.startActivity(it);
        }
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        switch (requestCode)
        {
            case RESULT_OK:
                Send.this.msg.setText("返回值的内容是" + data.getStringExtra("retmsg"));
                break;
            case RESULT_CANCELED:
                Send.this.msg.setText("操作取消");
                break;
            default:
                break;
        }
    }
}
