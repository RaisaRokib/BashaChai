package com.example.bashachai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewPost extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] area;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        area= getResources().getStringArray(R.array.area);

        spinner= findViewById(R.id.spinnerArea);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.sample_view,R.id.sampleId,area);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice= parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}