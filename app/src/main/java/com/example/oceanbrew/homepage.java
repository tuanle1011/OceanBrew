package com.example.oceanbrew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

public class homepage extends AppCompatActivity {
    SearchView search;
    ImageButton all,add,fav ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        all = (ImageButton) findViewById(R.id.imgbtn_allrecipes);
        add = (ImageButton) findViewById(R.id.imgbtn_add_detail);
        fav = (ImageButton) findViewById(R.id.imgbtn_wishlist_detail);

        final Intent i = new Intent(this,
                allrecipes.class);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
        final Intent ii = new Intent (this,sharing.class);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ii);
            }
        });
        final Intent iii = new Intent (this,wishlist.class);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iii);
            }
        });

    }
}