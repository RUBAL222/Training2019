package com.example.rubal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<String>adapter;
    void initViews()
    {
        getSupportActionBar().setTitle("News");
        listView=findViewById(R.id.ListView);

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        adapter.add("AAJ TAK");
        adapter.add("NDTV");
        adapter.add("Zee NEWS");
        adapter.add("CNN IBM");
        adapter.add("PTC");

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initViews();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String newsName=adapter.getItem(position);
        Toast.makeText(this,"You Selected"+newsName,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(ListViewActivity.this, WebViewActivity.class);
        startActivity(intent);

    }
}

