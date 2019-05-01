package com.example.rubal;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyFragmentsActivity extends AppCompatActivity {

    upperFragment upperFragment;
    lowerFragment lowerFragment;
    FragmentManager fragmentManager;

    void initViews(){
        upperFragment=new upperFragment();
        lowerFragment=new lowerFragment();

        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.upperFrame,upperFragment);
        fragmentManager.beginTransaction().add(R.id.lowerFrame,lowerFragment);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragments);
        initViews();
    }
}
