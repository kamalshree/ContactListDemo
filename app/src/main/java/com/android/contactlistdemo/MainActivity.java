package com.android.contactlistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> ContactName=new ArrayList<>();
    ArrayList<String> ContactNumber=new ArrayList<>();
    ContactAdapter adapter;
    RecyclerView myRecylerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImages();
    }

    private void initImages(){
        ContactName.add("James");
        ContactNumber.add("123-456-7890");

        ContactName.add("Charlie");
        ContactNumber.add("123-456-7890");

        ContactName.add("Kim");
        ContactNumber.add("123-456-7890");

        ContactName.add("Madona");
        ContactNumber.add("123-456-7890");

        ContactName.add("Arjan");
        ContactNumber.add("123-456-7890");

        ContactName.add("Henry");
        ContactNumber.add("123-456-7890");

        ContactName.add("Lisa");
        ContactNumber.add("123-456-7890");

        ContactName.add("Kate");
        ContactNumber.add("123-456-7890");

        ContactName.add("Robin");
        ContactNumber.add("123-456-7890");

        ContactName.add("Harry");
        ContactNumber.add("123-456-7890");

        ContactName.add("Kevin");
        ContactNumber.add("123-456-7890");

        ContactName.add("Rebecca");
        ContactNumber.add("123-456-7890");
        initRecyclerView();
    }

    private void initRecyclerView(){
        //sort ContactNames
        Collections.sort(ContactName);
        myRecylerView=findViewById(R.id.rv_recyclerview);
        adapter=new ContactAdapter(this,ContactName,ContactNumber);

        myRecylerView.setAdapter(adapter);
        myRecylerView.setLayoutManager(new LinearLayoutManager(this));

        //adding Divider
        myRecylerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
