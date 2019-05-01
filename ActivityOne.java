package com.example.rubal;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class ActivityOne extends AppCompatActivity implements View.OnClickListener{

    EditText etxtName,etxtPhone;
    Button Submit;

    void initView()
    {
        etxtName=findViewById(R.id.editTextName);
        etxtPhone=findViewById(R.id.editTextPhone);
        Submit =findViewById(R.id.buttonSubmit);
        Submit.setOnClickListener(this);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initView();
    }

    @Override
    public void onClick(View v) {

        //Person person =new Person();

        //person.name= etxtName.getText().toString();
        // person.phone= etxtPhone.getText().toString();


        //  Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
        //intent.putExtra("keyName",name) ;
        //intent.putExtra("keyPhone",phone);


        /*Bundle bundle = new Bundle();
        bundle.putString("keyName",name);
        bundle.putString("keyPhone",phone);
        bundle.putInt("keyAge",20);

        intent.putExtra("keyBundle",bundle);*/

        //intent.putExtra("keyPerson",person);

        //startActivity(intent);
        Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
        startActivityForResult(intent, 101);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        if (requestCode == 101 && resultCode == 201){
            String name = data.getStringExtra("keyName");
        String phone = data.getStringExtra("keyPhone");

        etxtName.setText(name);
        etxtPhone.setText(phone);
    }

    }
}
