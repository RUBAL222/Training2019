package com.example.rubal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

    public class AllNewsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

       // ListView listView;
        RecyclerView recyclerView;
        ArrayList<News> newsList;
        NewsAdapter newsAdapter;
        NewsRecyclerAdapter recyclerAdapter;

        void initViews()
        {
            //listView = findViewById(R.id.listView);
            recyclerView = findViewById(R.id.recyclerView);
            newsList = new ArrayList<>();

            News news1 = new News(R.drawable.folder, "NDTV", "https://ndtv.india.com");
            News news2 = new News(R.drawable.folder, "Zee News", "https://ndtv.india.com");

            newsList.add(news1);
            newsList.add(news2);

//         new NewsAdapter(this,R.layout.list_item,newsList);
//         listView.setAdapter(newsAdapter);
            recyclerAdapter=new NewsRecyclerAdapter(this,R.layout.list_item,newsList);
            GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(gridLayoutManager);

            recyclerView.setAdapter(recyclerAdapter);
        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_news);
            initViews();
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            News news = newsList.get(position);
            Intent intent = new Intent(AllNewsActivity.this, WebViewActivity.class);
            intent.putExtra("keyNews", newsList);
            startActivity(intent);

        }
    }
