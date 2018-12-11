package com.nanodegree.sam.guitarprog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Printer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.nanodegree.sam.guitarprog.adapters.MainAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);

        mLayoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.rv_list_of_chords);

        recyclerView.setLayoutManager(mLayoutManager);

        Log.d("Data ", getString(R.string.chord_data));



        try {
            JSONObject obj = new JSONObject(getString(R.string.chord_data));
            JSONArray jsonArray = obj.getJSONArray("chords");

            MainAdapter mainAdapter = new MainAdapter(jsonArray);
            recyclerView.setAdapter(mainAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){

        if (menuItem.getItemId() == R.id.menu_major){

            }
        if (menuItem.getItemId() == R.id.menu_minor){

        }
        return super.onOptionsItemSelected(menuItem);
    }


}
