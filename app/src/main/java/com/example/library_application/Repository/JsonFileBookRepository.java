package com.example.library_application.Repository;

import android.support.v7.app.AppCompatActivity;

import com.example.library_application.Model.Book;

import org.apache.commons.io.IOUtil;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

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

            Book[] books = new Book[bookArray.length()];

            for(int i = 0; i < bookArray.length(); i++) {
                books[i] = Book.fromJSONObject(bookArray.getJSONObject(i));
            }

            return books;
        } catch (JSONException e) {
            e.printStackTrace();
            return new Book[0];
        } catch (IOException e) {
            e.printStackTrace();
            return new Book[0];
        }
    }
}
