package com.example.healtherlogin;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class For_Obese_Program_list extends AppCompatActivity {
    private Button[] program_list= new Button[3];
    private String[] program_title = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_obese_program_list);
    }



}
