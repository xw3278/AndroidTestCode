package com.example.xw3278.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startService = (Button)findViewById(R.id.start_service);
        Button stopService = (Button)findViewById(R.id.stop_service);
        Button bindService = (Button)findViewById(R.id.bind_service);
        Button unbindService = (Button)findViewById(R.id.unbind_service);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.start_service:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent(this, MyService.class);
                startService(stopIntent);
                break;
            case R.id.bind_service:
                break;
            case R.id.unbind_service:
                break;
            default:
                break;
        }
    }
}
