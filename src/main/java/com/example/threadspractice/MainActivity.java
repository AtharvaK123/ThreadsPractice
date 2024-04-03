package com.example.threadspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);

        JSONObject schoolInfo = new JSONObject();
        //Part 1
        try {
            schoolInfo.put("name", "Atharva");
            schoolInfo.put("grade", "11");
            schoolInfo.put("ID", "1263280");
        }
        catch(Exception e){

        }

        try {
            tv.setText(schoolInfo.get("name").toString())
            ;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        //Part 2
        JSONObject compSci = new JSONObject();
        try {
            compSci.put("Grade", "A");
            compSci.put("Percentage", 97);
            schoolInfo.put("Computer Science", compSci);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        Log.d("School: ", schoolInfo.toString());



        try {
            JSONObject findcourse;
            findcourse = schoolInfo.getJSONObject("Computer Science");
            tv.setText(findcourse.get("Grade").toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        JSONArray clubs;
        clubs = new JSONArray();
        clubs.put("Computer Science");
        clubs.put("CS Honor Society");


        try {
            JSONObject gwc = new JSONObject();
            gwc.put("gwc", "Girls Who Code");
            clubs.put(gwc);
            schoolInfo.put("clubs", clubs);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        Log.d("SchoolArray", clubs.toString());
        Log.d("school", schoolInfo.toString());
    }
}