package com.example.bhaghyalakshmi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity
{
        Button b1;
        EditText ed1;

        TextView tx1;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.userid);



        tx1 = (TextView)findViewById(R.id.layout);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        if(ed1.getText().toString().equals("galladivya")) {
        Toast.makeText(getApplicationContext(),
        "Redirecting...",Toast.LENGTH_SHORT).show();
        }
        tx1.setVisibility(View.VISIBLE);
        tx1.setBackgroundColor(Color.RED);
        finish();



        }
        });

        }
        }