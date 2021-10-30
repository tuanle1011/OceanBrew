package com.example.oceanbrew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class wishlist extends AppCompatActivity {
    ImageButton home_wish, add_wishlist, backformwishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        home_wish = (ImageButton) findViewById(R.id.imgbtn_home_detail);
        add_wishlist = (ImageButton) findViewById(R.id.imgbtn_add_detail);
        backformwishlist = (ImageButton) findViewById(R.id.imgbtn_detailback);

        final Intent i = new Intent (this,homepage.class);
        home_wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
        final Intent ii = new Intent (this,sharing.class);
        add_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ii);
            }
        });

        backformwishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}