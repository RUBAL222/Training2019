package com.example.rubal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    //    SharedPreferences.Editor editor;
//
    TextView textshow;
    String name;

    void initViews() {
        textshow = findViewById(R.id.textView);
//
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//
//
    }

        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
//        SharedPreferences preferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);
            //     String name=preferences.getString("nameKey","");

       /* TextView textView=(TextView)findViewById(R.id.textView6);
        textView.setText(name);
*/
            initViews();
//
            name = sharedPreferences.getString("nameKey", "NA");
            textshow.setText("welcome" + name);

        }
    }
