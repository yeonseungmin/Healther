package com.example.healtherlogin;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Golden_Six_Do_Situp extends AppCompatActivity {

    private Button record, pause, finish;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.golden_six_program_do_situp);

        record = (Button) findViewById(R.id.Record);
        pause = (Button) findViewById(R.id.Pause);
        finish = (Button) findViewById(R.id.Finish);


    }


}
