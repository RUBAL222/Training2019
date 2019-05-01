package com.example.rubal.ui;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rubal.R;
import com.example.rubal.adapter.CustomersAdapter;
import com.example.rubal.model.Customer;
import com.example.rubal.model.Util;

import java.util.ArrayList;

public class AllCustomerActivity extends AppCompatActivity {

    ContentResolver resolver;
    RecyclerView recyclerView;

    ArrayList<Customer> customers;
    CustomersAdapter customerAdapter;

   int position;
   Customer customer;

    void initViews(){
        resolver=getContentResolver();
        recyclerView=findViewById(R.id.recyclerView);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_customer);
        initViews();
        fetchCustomersFromDB();

    }
    void fetchCustomersFromDB()
    {
        String[] projection ={Util.COL_ID,Util.COL_NAME,Util.COL_PHONE,Util.COL_EMAIL};
        Cursor cursor=resolver.query(Util.CUSTOMER_URI,projection,null,null,null);
        if (cursor!=null) {
            customers=new ArrayList<>();
            while(cursor.moveToNext())
            {
                Customer customer=new Customer();
                customer.id=cursor.getInt(cursor.getColumnIndex(Util.COL_ID));
                customer.name=cursor.getString(cursor.getColumnIndex(Util.COL_NAME));
                customer.phone=cursor.getString(cursor.getColumnIndex(Util.COL_PHONE));
                customer.email=cursor.getString(cursor.getColumnIndex(Util.COL_EMAIL));

                customers.add(customer);

            }

            getSupportActionBar().setTitle("Total Customers:");
            customerAdapter=new CustomersAdapter(this,R.layout.list_item,customers);
            customerAdapter.setOnRecyclerItemClickListener();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(customerAdapter);
        }

    }
    void showCustomerDetails()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(customer.name+" Details:");
        builder.setMessage(customer.toString());
        builder.setPositiveButton("Done",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    void showOptions(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String[] items = {"View "+customer.name, "Update "+customer.name, "Delete "+customer.name, "Cancel"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which){
                    case 0:
                        showCustomerDetails();
                        break;

                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:

                        break;
                }

            }
        });

        //builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
    }


     public void onItemClick(int position) {
        this.position = position;
        customer = customers.get(position);
        //Toast.makeText(this,"You Clicked on Position:"+position,Toast.LENGTH_LONG).show();
        showOptions();
    }

}

