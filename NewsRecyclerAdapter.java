package com.example.rubal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder>
{
    Context context;
    int resource;
    ArrayList<News> objects;


    public NewsRecyclerAdapter(Context context, int resource, ArrayList<News> objects)
    {

        this.context=context;
        this.resource=resource;
        this.objects=objects;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(resource,parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
     News news=objects.get(i);
        viewHolder.imageView.setBackgroundResource(news.image);
        viewHolder.texttitle.setText(news.title);
        viewHolder.texttitle.setText(news.url);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView texttitle;
        TextView texturl;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView2);
            texttitle=itemView.findViewById(R.id.textViewtitle);
            texturl=itemView.findViewById(R.id.textView);



        }
    }
    }