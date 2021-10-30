package com.example.oceanbrew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class allrecipes extends AppCompatActivity {
    ImageButton backformallrecipes, home_recback, add_recback, wishlist_recback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allrecipes);

        backformallrecipes = (ImageButton) findViewById(R.id.imgbtn_detailback);
        home_recback = (ImageButton) findViewById(R.id.imgbtn_home_detail);
        add_recback = (ImageButton) findViewById(R.id.imgbtn_add_detail);
        wishlist_recback = (ImageButton ) findViewById(R.id.imgbtn_wishlist_detail);

        backformallrecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final Intent i = new Intent (this,homepage.class);
        home_recback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
        final Intent ii = new Intent (this,sharing.class);
        add_recback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ii);
            }
        });

        final Intent iii = new Intent (this,wishlist.class);
        wishlist_recback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iii);
            }
        });
    }
}