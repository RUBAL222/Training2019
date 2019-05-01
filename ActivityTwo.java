package com.example.rubal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {

    EditText etxtName,etxtPhone;
    Button btnback;

    void initView() {
        etxtName = findViewById(R.id.editTextName);
        etxtPhone = findViewById(R.id.editTextPhone);
        btnback = findViewById(R.id.buttonback);
        btnback.setOnClickListener(this);

        //Intent rcv = getIntent();
        //String name = rcv.getStringExtra("keyName");
        //String phone = rcv.getStringExtra("keyPhone");
        /*Bundle rcvBun=rcv.getBundleExtra("keyBundle");
        String name=rcvBun.getString("keyName");
        String phone=rcvBun.getString("keyPhone");
        int age=rcvBun.getInt("keyAge",0);*/

        //Person person=(Person)rcv.getSerializableExtra("keyPerson");

        //etxtName.setText(person.name);
        //etxtPhone.setText(person.phone);
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
    }

    @Override
    public void onClick(View v) {
        String name=etxtName.getText().toString();
        String phone=etxtPhone.getText().toString();
        Intent data=new Intent();
        data.putExtra("keyName",name);
        data.putExtra("keyPhone",phone);

        setResult(201,data);

        finish();

    }
}
