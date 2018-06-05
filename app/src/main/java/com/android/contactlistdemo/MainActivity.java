package com.android.contactlistdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> ContactImage=new ArrayList<>();
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
        ContactImage.add("https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg");
        ContactName.add("James");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/69776/tulips-bed-colorful-color-69776.jpeg");
        ContactName.add("Charlie");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/46216/sunflower-flowers-bright-yellow-46216.jpeg");
        ContactName.add("Kim");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/132474/pexels-photo-132474.jpeg");
        ContactName.add("Madona");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/54320/rose-roses-flowers-red-54320.jpeg");
        ContactName.add("Arjan");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/55748/flower-blossom-bloom-blue-55748.jpeg");
        ContactName.add("Henry");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/133081/pexels-photo-133081.jpeg");
        ContactName.add("Lisa");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/47360/flowers-summer-pink-nature-47360.jpeg");
        ContactName.add("Kate");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/714918/pexels-photo-714918.jpeg");
        ContactName.add("Robin");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/414661/pexels-photo-414661.jpeg");
        ContactName.add("Harry");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/53135/hydrangea-blossom-bloom-flower-53135.jpeg");
        ContactName.add("Kevin");
        ContactNumber.add("123-456-7890");

        ContactImage.add("https://images.pexels.com/photos/462402/pexels-photo-462402.jpeg");
        ContactName.add("Rebecca");
        ContactNumber.add("123-456-7890");
        initRecyclerView();
    }

    private void initRecyclerView(){
        myRecylerView=findViewById(R.id.rv_recyclerview);
        adapter=new ContactAdapter(this,ContactImage,ContactName,ContactNumber);

        myRecylerView.setAdapter(adapter);
        myRecylerView.setLayoutManager(new LinearLayoutManager(this));

        //adding Divider
        myRecylerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
