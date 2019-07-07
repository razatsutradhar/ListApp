package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] descriptions;
    String[] prices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();                                                             //created a shortcut for Resources
        myListView = findViewById(R.id.myListView);                                                 //Imported the list from the activity_main file
        items = res.getStringArray(R.array.items);                                                  //Got the String-array we put in resources
        descriptions = res.getStringArray((R.array.descriptions));                                  //^
        prices = res.getStringArray(R.array.prices);                                                //^

        ItemAdapter IA = new ItemAdapter(this, items, descriptions, prices);                     //we create an item adapter inorder to set up each item in the list
        myListView.setAdapter(IA);             //we set the adapter of the listView to the itemAdater which sets up every item like the adapter with the getView() method
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {                   //what happens when an item is clicked
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {         //on click listener
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);  //create an intent that points to the DetailActivity class
                showDetailActivity.putExtra("com.example.listapp.itemIndex", i);              //we put the index of the item clicked in the intent to get the image
                startActivity(showDetailActivity);                                               //we show the activity in DetailActivity and run the onCreate method there
            }
        });
    }
}
