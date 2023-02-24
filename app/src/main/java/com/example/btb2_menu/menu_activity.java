package com.example.btb2_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class menu_activity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txt = findViewById(R.id.tv_menu);
        Intent intent = getIntent();
        txt.setText(intent.getStringExtra("menu_activity").toString());
    }
}