package com.example.healtherlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Program extends AppCompatActivity {

    String UID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program);
        Intent intent = getIntent();

        BottomNavigationView bottom_navi = findViewById(R.id.bottom_navi);
        bottom_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.Diary){
                    Intent Diary= new Intent(Program.this, Diary_Home.class);
                    startActivity(Diary);

                }else if(item.getItemId()==R.id.Calculate){
                    Toast.makeText(Program.this, "현재 화면입니다", Toast.LENGTH_SHORT).show();
                }else if(item.getItemId()==R.id.Recommendation){
                    Intent Recommendation= new Intent(Program.this, Program_BMI.class);
                    startActivity(Recommendation);

                }

                return false;

            }
        });

    }

    public void input5RM(View v) {
        Intent input = new Intent(Program.this, Program_input.class);
        startActivity(input);
    }

    public void user(View v) {
        Intent show = new Intent(Program.this, Program_show.class);
        startActivity(show);

    }
}








