package com.example.MyDragListViewDemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WANGZHENGZE on 2014/9/15.
 */
public class MyAdapter extends BaseAdapter {

    private ArrayList<String> myList;
    private Context context;

    public MyAdapter(Context context, ArrayList<String> myList) {
        this.context = context;
        this.myList = myList;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.text);
        tv.setText("你好，我是NO." + myList.get(i));
        return convertView;
    }
}
