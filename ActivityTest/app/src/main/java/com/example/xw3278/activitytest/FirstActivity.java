package com.example.xw3278.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.d("FirstActivity", this.toString());
        Button button_one = (Button)findViewById(R.id.button_1);
        button_one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //1. toast
                //Toast.makeText(FirstActivity.this, "You clicked button 1",
                //        Toast.LENGTH_SHORT).show();
                //2. finish
                //finish();
                //3. (1)Intent
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity(intent);
                // (2)Intent
                //Intent intent = new Intent("com.example.xw3278.activitytest.ACTION_START");
                //intent.addCategory("com.example.xw3278.activitytest.MY_CATEGORY");
                //startActivity(intent);
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //startActivity(intent);
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                //startActivity(intent);
                //String data = "Hello secondActivity!";
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //intent.putExtra("extra_data", data);
                //startActivity(intent);
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
                //Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                //startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
        //return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }
}
