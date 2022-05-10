package com.example.academy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private SharedPreferences sharedPrefs;

    public TextView name;
    public TextView date;
    public TextView height;
    public TextView weight;
    public String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.profile);

        name = findViewById(R.id.nameProfile);
        date = findViewById(R.id.ageProfile);
        height = findViewById(R.id.heightProfile);
        weight = findViewById(R.id.weightProfile);

        sharedPrefs = getSharedPreferences("dados", MODE_PRIVATE);

        name.setText(sharedPrefs.getString("name", ""));
        date.setText(sharedPrefs.getString("Date", ""));
        height.setText(sharedPrefs.getString("heightA", "0"));
        weight.setText(sharedPrefs.getString("Weight", "0"));

    }
    public void onButtonClicked(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }
}