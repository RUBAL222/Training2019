package com.example.rubal;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersistanceActivity extends AppCompatActivity {

    EditText eTxtName;
    EditText etxtPhone;
    EditText etxtPassword;
    EditText etxtEmail;
    Button btnSubmit;

    String data;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    void initViews(){
        eTxtName=findViewById(R.id.editText4);
        etxtPhone=findViewById(R.id.editText5);
        etxtPassword=findViewById(R.id.editText6);
        etxtEmail=findViewById(R.id.editText7);
        btnSubmit=findViewById(R.id.button5);

        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //data = eTxtData.getText().toString();
                //saveDataInInternalFile();

                //readDataFromInternalFile();

                //saveDataInExternalFile();

                //editor.putString("keyQuote",data);
                //sharedPreferences.edit().apply(); // Save the Data in XML File | Background Thread
                //editor.commit();  // Save the Data in XML File

                //Toast.makeText(PersistanceActivity.this,"Data Saved in SharedPrefs",Toast.LENGTH_LONG).show();
                //eTxtData.setText("");

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistance);
        initViews();

        data=sharedPreferences.getString("keyQuote","NA");

    }
    void saveDataInInternalFile(){
        try{
            FileOutputStream outputStream= openFileOutput("data.txt",MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();

            Toast.makeText(this,"Data saved in Internal File",Toast.LENGTH_LONG).show();
            eTxtName.setText("");
            etxtPhone.setText("");
            etxtPassword.setText("");
            etxtEmail.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void readDataInInternalFile(){
        try{
            FileInputStream inputStream= openFileInput("data.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

            data =reader.readLine();
            eTxtName.setText(data);
            etxtPhone.setText(data);
            etxtPassword.setText(data);
            etxtEmail.setText(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void saveDataInExternalFile(){
        try{
            String path= Environment.getExternalStorageDirectory().getPath()+"/data.txt";
            FileOutputStream outputStream=new FileOutputStream(path);
            outputStream.write(data.getBytes());
            outputStream.close();

            Toast.makeText(this,"Data saved in External File",Toast.LENGTH_LONG).show();
            eTxtName.setText("");
            etxtPhone.setText("");
            etxtPassword.setText("");
            etxtEmail.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void readDataFromExternalFile(){
        try{
            String path =Environment.getExternalStorageDirectory().getPath()+"/data.txt";
            FileInputStream inputStream=new FileInputStream(path);
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream)) ;
            
            data=reader.readLine();
            eTxtName.setText(data);
            etxtPhone.setText(data);
            etxtPassword.setText(data);
            etxtEmail.setText(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}