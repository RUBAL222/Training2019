package com.example.rubal;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class AllSongsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<String> adapter;
    String path;

    void initViews()
    {
        listView=findViewById(R.id.listView);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
//        adapter.add("Song1.mp3");
//        adapter.add("Song2.mp3");
//        adapter.add("Song3.mp3");
//        adapter.add("Song4.mp3");
//        adapter.add("Song5.mp3");

        path= Environment.getExternalStorageDirectory().getPath();
        File file=new File(path);

        String[] files=file.list();

        for (String s: files){
            if(s.endsWith(".mp3")){
                adapter.add(s);
            }
        }
        listView.setAdapter(adapter);
        listView.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityallsongs);
        initViews();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String songToPlay=adapter.getItem(position);
        Toast.makeText(this,"You selected"+songToPlay,Toast.LENGTH_LONG).show();
    }
}
