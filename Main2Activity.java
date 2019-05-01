package com.example.rubal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    HomeActivity homeActivity;

    EditText ed1,ed2,ed3;
    Button b1;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Password = "passwordKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        b1=(Button)findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override

    public void onClick(View view) {

        String n = ed1.getText().toString();
        String ph = ed2.getText().toString();
        String pass = ed3.getText().toString();

        SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Name, n);
        editor.putString(Phone, ph);
        editor.putString(Password, pass);
        editor.commit();
        editor.putBoolean("save",true);
        editor.apply();

        Toast.makeText(Main2Activity.this, "Saved in shared Preferences", Toast.LENGTH_LONG).show();

      //  Intent intent =new Intent(Main2Activity.this,HomeActivity.class);
        //startActivity(intent);
    }
});

        }

    public void onClick(View view) {

        Intent intent =new Intent(Main2Activity.this,HomeActivity.class);
        startActivity(intent);
    }
}




