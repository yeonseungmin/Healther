package com.example.healtherlogin;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Golden_Six_Do_Neck extends AppCompatActivity {

    private Button record, pause, Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.golden_six_program_do_neck);

        record = (Button) findViewById(R.id.Record);
        pause = (Button) findViewById(R.id.Pause);
        Next = (Button) findViewById(R.id.Next);

    }

    public void Next(View v) {
        Intent Next = new Intent(Golden_Six_Do_Neck.this,Golden_Six_Do_Curl.class);
        startActivity(Next);
    }

}
