package com.example.rubal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter  extends ArrayAdapter<News>{

    Context context;
    int resource;
    ArrayList<News>objects;
    public NewsAdapter(Context context, int resource, ArrayList<News> objects)
    {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;

    }
    public View getView(int position, View ConvertView, ViewGroup parent)
    {
        View view= LayoutInflater.from(context).inflate(resource,parent,false);

        ImageView imageView=view.findViewById(R.id.imageView2);
        TextView textView=view.findViewById(R.id.textViewtitle);
        TextView textView1=view.findViewById(R.id.textView);

        News news=objects.get(position);

        imageView.setBackgroundResource(news.image);
        textView.setText(news.title);
        textView1.setText(news.url);
        return view;


    }
}
