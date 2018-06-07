package com.example.xw3278.litepaltest;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createDatabase = (Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Connector.getDatabase();
            }
        });

        Button addData = (Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Book book = new Book();
                book.setName("the da vinci code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(13.45);
                book.setPress("Unknow");
                book.save();
            }
        });

        Button updateData = (Button)findViewById(R.id.update_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Book book = new Book();
                book.setPrice(18.45);
                book.setPress("anchor");
                book.updateAll("name=? and author = ?",
                         "the lsot symbol", "Dan Brown");

                //Book book = new Book();
                //book.setToDefault("pages");
                //book.updateAll();
            }
        });

        Button DeleteData = (Button)findViewById(R.id.delete_data);
        DeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DataSupport.deleteAll(Book.class, "price < ?", "15");
            }
        });

        Button QueryData = (Button)findViewById(R.id.query_data);
        QueryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                List<Book> books = DataSupport.findAll(Book.class);
            }
        });


    }
}
