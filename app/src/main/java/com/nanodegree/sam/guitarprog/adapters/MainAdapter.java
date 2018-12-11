package com.nanodegree.sam.guitarprog.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.nanodegree.sam.guitarprog.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainRecyclerViewHolder>{

    public JSONArray jsonArray;

    public MainAdapter(JSONArray jsonArrayData){
        jsonArray = jsonArrayData;

    }

    public static class MainRecyclerViewHolder extends RecyclerView.ViewHolder{
        View view;
        public MainRecyclerViewHolder(View viewer) {

            super(viewer);
            view = viewer;

        }
    }

    @Override
    public MainAdapter.MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_chords, parent, false);

        return new MainRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewHolder mainRecyclerViewHolder, int position){
        TextView textView = mainRecyclerViewHolder.view.findViewById(R.id.tv_chord);
        try {
            textView.setText(String.valueOf(jsonArray.get(position)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    @Override
    public int getItemCount() {
        return jsonArray.length();
    }


}
