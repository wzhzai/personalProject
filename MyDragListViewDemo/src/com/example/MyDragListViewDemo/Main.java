package com.example.MyDragListViewDemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayList<String> myList = new ArrayList<String>();
        for (int i=0; i<10; i++) {
            myList.add(String.valueOf(i));
        }
        ListView listView = (ListView) findViewById(R.id.list);
        MyAdapter myAdapter = new MyAdapter(this, myList);
        listView.setAdapter(myAdapter);

    }
}
