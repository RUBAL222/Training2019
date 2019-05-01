package com.example.rubal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    void initViews()
    {
        Intent rcv=getIntent();
        News news=(News)rcv.getSerializableExtra("keyNews");
        getSupportActionBar().hide();
        getSupportActionBar().setTitle(news.title);
        webView=findViewById(R.id.webView);

        //WebViewClient client=new WebViewClient();
        //webView.setWebViewClient(client);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("news.url");

}   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initViews();
}
}


