package com.example.oceanbrew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class drinksdetail extends AppCompatActivity {
    ImageButton home_detail, wish_detail, add_detail, backfgrmdetail ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinksdetail);

        home_detail = (ImageButton) findViewById(R.id.imgbtn_home_detail);
        wish_detail = (ImageButton) findViewById(R.id.imgbtn_wishlist_detail);
        add_detail = (ImageButton) findViewById(R.id.imgbtn_add_detail);
        backfgrmdetail = (ImageButton) findViewById(R.id.imgbtn_detailback);

        backfgrmdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Intent i = new Intent(this,homepage.class);
        home_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
        final Intent ii = new Intent (this,wishlist.class);
        wish_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ii);
            }
        });
        final Intent iii = new Intent (this,sharing.class);
        add_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iii);
            }
        });
    }
}