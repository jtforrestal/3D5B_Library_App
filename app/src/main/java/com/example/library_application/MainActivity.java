package com.example.library_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.library_application.Controls.BookClickListener;
import com.example.library_application.Controls.BookRecyclerViewAdapter;
import com.example.library_application.Model.Book;
import com.example.library_application.Repository.BookRepository;
import com.example.library_application.Repository.JsonFileBookRepository;
import com.example.library_application.Utils.Prefs;
import com.example.library_application.Utils.searchActivity;

public class MainActivity extends AppCompatActivity implements BookClickListener {


    public RecyclerView recyclerView;
    Book[] books = new Book[0];
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BookRecyclerViewAdapter bookAdapter = new BookRecyclerViewAdapter(this,new Book[0]);
        recyclerView.setAdapter(bookAdapter);
        bookAdapter.setBookClickListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(MainActivity.this, searchActivity.class);
                startActivity(searchIntent);
                Prefs prefs = new Prefs(MainActivity.this);
                String search = prefs.getSearch();

            }
        });


        try {
            BookRepository repo =  new JsonFileBookRepository(this, R.raw.testfile);//new StaticBookRepository
            bookAdapter.bookList = repo.getBooks();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view, int position){
        BookRecyclerViewAdapter adapter = (BookRecyclerViewAdapter) recyclerView.getAdapter();
        final Book chosen_book = adapter.bookList[position];
        Intent intent = new Intent(this, FullViewActivity.class);

        intent.putExtra("TITLE", chosen_book.getTitle());
        intent.putExtra("AUTHOR", chosen_book.getAuthors());
        intent.putExtra("DESCRIPTION",chosen_book.getDescription());
        intent.putExtra("IMAGES", chosen_book.getImages());
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
