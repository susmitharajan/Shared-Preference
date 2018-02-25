package com.example.susmitharajan.notepad;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sf;
    EditText name;
    public static final String preferences = "pref";
    public static final String saveIt = "saveKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText);
        sf = getSharedPreferences(preferences, Context.MODE_PRIVATE);

        if (sf.contains(saveIt)) {
            name.setText(sf.getString(saveIt, ""));
        }
    }


    @Override
    public void onBackPressed() {
        String store = name.getText().toString();
        SharedPreferences.Editor editor = sf.edit();
        editor.putString(saveIt, store);
        editor.commit();
        finish();
    }

    public void save(View view){

        String store = name.getText().toString();
        SharedPreferences.Editor editor = sf.edit();
        editor.putString(saveIt, store);
        editor.commit();


    }

    public void remove(View view){

        name = (EditText) findViewById(R.id.editText);
        name.setText("");

    }

    public void retrieve(View view){

        name = (EditText) findViewById(R.id.editText);
        sf = getSharedPreferences(preferences, Context.MODE_PRIVATE);

        if(sf.contains(saveIt)){
            name.setText(sf.getString(saveIt, ""));
        }

    }
}
