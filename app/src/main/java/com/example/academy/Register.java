package com.example.academy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Register extends AppCompatActivity {
    private EditText name;
    private EditText date;
    private EditText height;
    private EditText weight;
    private RadioGroup sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.register);
        name = findViewById(R.id.nameH);
        date = findViewById(R.id.date);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        sex = findViewById(R.id.sex);
        Button salvar = (Button) findViewById(R.id.save);
        salvar.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                        SharedPreferences sharedPrefs = getSharedPreferences("dados", Context.MODE_PRIVATE);
                        SharedPreferences.Editor sharedPrefsEditor = sharedPrefs.edit();

                        sharedPrefsEditor.putString("name", name.getText().toString());
                        //sharedPrefsEditor.putString("Date", StString.valueOf(date));
                        //sharedPrefsEditor.putFloat("height", Float.parseFloat(height.getText().toString()));
                        //sharedPrefsEditor.putFloat("weight", Float.parseFloat(String.valueOf(weight.getText().toString())));
                        //sharedPrefsEditor.putString("Sex", String.valueOf(sex));
                        sharedPrefsEditor.apply();
            }
        });




    }
    protected void onButtonClicked(View view){


    }
}