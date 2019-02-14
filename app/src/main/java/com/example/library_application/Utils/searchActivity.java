package com.example.library_application.Utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.library_application.R;

public class searchActivity extends com.example.library_application.MainActivity {

    //private static final String TAG = MainActivity.class.getSimpleName();
    //private EditText mBookInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_book);
        //mBookInput = (EditText) findViewById(R.id.bookInput);
    }
}
