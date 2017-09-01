package com.example.xw3278.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Intent intent = getIntent();
        //String data = intent.getStringExtra("extra_data");
        //Log.d("SecondActivity", data);
        Button button_two = (Button)findViewById(R.id.button_2);
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "alex: hello FirstActivity!");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("data_return", "alex: hello FirstActivity!");
        setResult(RESULT_OK, intent);
        finish();
    }
}
