package com.example.rubal.ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rubal.R;
import com.example.rubal.model.Customer;
import com.example.rubal.model.Util;

public class AddCustomerActivity extends AppCompatActivity {

    EditText eTxtName,eTxtPhone,eTxtEmail;
    Button btnSubmit;

    Customer customer;
    ContentResolver resolver;

    boolean updateMode;


    void initViews()
    {
        resolver=getContentResolver();
        eTxtName=findViewById(R.id.editTextName);
        eTxtPhone=findViewById(R.id.editTextPhone);
        eTxtEmail=findViewById(R.id.editTextEmail);
        btnSubmit=findViewById(R.id.buttonAdd);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer.name = eTxtName.getText().toString();
                customer.phone = eTxtPhone.getText().toString();
                customer.email = eTxtEmail.getText().toString();

                addCustomerInDB();
            }
        });
        Intent rcv=getIntent();
        updateMode=rcv.hasExtra("keyCustomer");
        if(updateMode)
        {
            customer=(Customer)rcv.getSerializableExtra("keyCustomer");
            eTxtName.setText(customer.name);
            eTxtPhone.setText(customer.phone);
            eTxtEmail.setText(customer.email);
            btnSubmit.setText("updated customer");
        }

    }

    void addCustomerInDB(){

        ContentValues values=new ContentValues();
        values.put(Util.COL_NAME,customer.name);
        values.put(Util.COL_PHONE,customer.phone);
        values.put(Util.COL_EMAIL,customer.email);

        Uri uri=resolver.insert(Util.CUSTOMER_URI,values);
        Toast.makeText(this,customer.name+ "ADDED IN DATABASE:"+uri.getLastPathSegment(), Toast.LENGTH_SHORT).show();

        clearFields();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        initViews();
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(1,101,1,"All Customers");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item ){
        int id =item.getItemId();
        if(id==101){
            Intent intent =new Intent(AddCustomerActivity.this,AllCustomerActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);

    }
    void clearFields()
    {
        eTxtName.setText("");
        eTxtPhone.setText("");
        eTxtEmail.setText("");
    }
}
