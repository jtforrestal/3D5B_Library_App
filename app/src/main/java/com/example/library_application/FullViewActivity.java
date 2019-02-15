package com.example.library_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library_application.Controls.BookRecyclerViewAdapter;
import com.squareup.picasso.Picasso;

public class FullViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_full_page);

        Intent intent = getIntent();
        //String title = intent.getStringExtra("TITLE");
        //String authors = intent.getStringExtra("AUTHOR");
        //String description = intent.getStringExtra("DESCRIPTION");
        //String images = intent.getStringExtra("IMAGE");

        //TextView titleView = findViewById(R.id.bookTitleID);
        //TextView authorView = findViewById(R.id.bookAuthorID);
        //TextView descriptionView = findViewById(R.id.bookDescriptionID);
        //ImageView coverView = findViewById(R.id.bookImageID);

        //titleView.setText(title);
        //authorView.setText(authors);
        //descriptionView.setText(description);

        //if (images.length() > 0) {
         //   Picasso.get()
           //         .load(images)
             //       .resize(100,120).centerCrop()
               //     .placeholder(android.R.drawable.ic_menu_slideshow)
                 //   .into(coverView);
        //}
        //else
        //{
        //    Picasso.get().load(android.R.drawable.ic_menu_slideshow).into(coverView);
        //}

    }

}
