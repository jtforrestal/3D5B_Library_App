package com.example.library_application.Utils;
import android.content.SharedPreferences;
import android.app.Activity;

public class Prefs { //save search terms into our prefereneces

    SharedPreferences sharedPreferences;

    public Prefs(Activity activity){
        sharedPreferences=activity.getPreferences(activity.MODE_PRIVATE);
    }

    public void setSearch(String search){
        sharedPreferences.edit().putString("search", search).commit();
    }
    public String getSearch(){
        return sharedPreferences.getString("search"," C++ Complete Guide");
    }
}

