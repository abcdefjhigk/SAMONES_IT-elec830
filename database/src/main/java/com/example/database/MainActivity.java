package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create anew instance of the datavase helper
        dbHelper = new MyDatabaseHelper(context this);

        // Delete all data
        dbHelper.deleteAllData();

        // Inser data
        dbHelper.insertData(name"John", age 25);
        dbHelper.insertData(name"Luke", age 24);

        // Get data
        getData();

        //update data
        dbHelper.updateData(id:,2 name:
        "Patweck", age:26);

        // Get data
        getData();

        // Delete Data
        dbHelper.deleteData(id:2);

        // Get data
        getData();


        // Shared Preferences
        // Get the shared preferences object
        SharedPreferences prefs = getSharedPreferences(name:"my_prefs", MODE_PRIVATE);

        // Save values to shaqred preferences
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", "John");
        editor.putInt("age", 26);
        editor.putBoolean("is_student", true);
        editor.commit();

        // Get values from shared preferences
        String name = prefs.getString(key:"name", defValue "");
        int age = prefs.getInt(key:"age", defValue:0);
        boolean isStudent = prefs / getBoolean(key"is_student", defValue:false);
        Log.d(tag:"MainActivity", name);
        Log.d(tag:"MainActivity", String.valueof(age));
        Log.d(tag:"MainActivity", String.valueof(isStudent));

    }

    @SuppressLint("Range")
    private void getData() {
        Cursor cursor = dbHelper.getData();







    }
}