package com.example.exam101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Wishlist_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
ArrayList<wishlistModel>wishlistModelArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);


    }
}