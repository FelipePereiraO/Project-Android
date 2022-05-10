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
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Register extends AppCompatActivity {
    private SharedPreferences sharedPrefs;
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



        sharedPrefs = getSharedPreferences("dados", MODE_PRIVATE);
        name.setText(sharedPrefs.getString("name", ""));
        date.setText(sharedPrefs.getString("Date", ""));
        height.setText(sharedPrefs.getString("heightA", ""));
        weight.setText(sharedPrefs.getString("Weight", ""));
        Integer sexo = sharedPrefs.getInt("Sex", 0);

        if(sexo == R.id.sexmen) {
            sex.check(R.id.sexmen);
        }else{
            sex.check(R.id.sexwoman);
        }

        Button salvar = (Button) findViewById(R.id.save);
        salvar.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                        sharedPrefs = getSharedPreferences("dados", Context.MODE_PRIVATE);
                        SharedPreferences.Editor sharedPrefsEditor = sharedPrefs.edit();
                        sharedPrefsEditor.putString("name", name.getText().toString());
                        sharedPrefsEditor.putString("Date", date.getText().toString());
                        sharedPrefsEditor.putString("heightA",height.getText().toString().trim());
                        sharedPrefsEditor.putString("Weight", weight.getText().toString());
                        sharedPrefsEditor.putInt("Sex", sex.getCheckedRadioButtonId());
                        sharedPrefsEditor.apply();

                        Intent intent = new Intent(Register.this, Home.class);
                        startActivity(intent);

            }
        });




    }
    public void onButtonClicked(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }
}