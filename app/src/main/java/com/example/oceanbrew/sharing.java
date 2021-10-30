package com.example.oceanbrew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class sharing extends AppCompatActivity {
    ImageButton backformsharing, home_shaback, wishlist_shaback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing);

        backformsharing = (ImageButton) findViewById(R.id.imgbtn_detailback);
        home_shaback = (ImageButton) findViewById(R.id.imgbtn_home_detail);
        wishlist_shaback = (ImageButton) findViewById(R.id.imgbtn_wishlist_detail);

        backformsharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Intent i = new Intent (this,homepage.class);
        home_shaback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

        final Intent ii = new Intent (this,wishlist.class);
        wishlist_shaback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ii);
            }
        });
    }
}