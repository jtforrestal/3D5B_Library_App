package com.example.library_application.Repository;

import android.support.v7.app.AppCompatActivity;

import com.example.library_application.Model.Book;

import org.apache.commons.io.IOUtil;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonFileBookRepository extends BookRepository {
    public JsonFileBookRepository(AppCompatActivity activity, int resourceId) {
        this.activity = activity;
        this.resourceId = resourceId;
    }

    private final AppCompatActivity activity;
    private final int resourceId;

    @Override
    protected Book[] getBooksInternal() {
        InputStream fileStream = this.activity.getResources().openRawResource(this.resourceId);
        try {
            JSONArray bookArray = new JSONArray(IOUtil.toString(fileStream));

            ArrayList<Book> books = new ArrayList<>(bookArray.length());

            for(int i = 0; i < bookArray.length(); i++) {
                Book book = Book.fromJSONObject(bookArray.getJSONObject(i));
                if (book.getId() != null && book.getTitle() != null && book.getImages().length > 0)
                {
                    books.add(book);
                }
            }

            return books.toArray(new Book[0]);
        } catch (JSONException e) {
            e.printStackTrace();
            return new Book[0];
        } catch (IOException e) {
            e.printStackTrace();
            return new Book[0];
        }
    }
}
