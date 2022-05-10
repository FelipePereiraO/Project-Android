package com.example.academy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private SharedPreferences sharedPrefs;
    public TextView name;
    public String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.home);
        name = findViewById(R.id.nameH);
        sharedPrefs = getSharedPreferences("dados", MODE_PRIVATE);
        result = sharedPrefs.getString("name", "");
        if(result == "") {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        }
        name.setText(result);
    }

    public void onButtonClicked(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }

    public void onButtonProfile(View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
    public void onButtonQuit(View view){
        finish();
        System.exit(0);
    }
}