package com.example.healtherlogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class For_UnderWeight_Program_list extends AppCompatActivity {

    private Button[] program_list= new Button[3];
    private String strBMI, strWeight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.for_underweight_program_list);
        program_list[0] = (Button) findViewById(R.id.golden_six_underweight);
        program_list[1] = (Button) findViewById(R.id.program_underweight2);
        program_list[2] = (Button) findViewById(R.id.program_underweight3);

        Intent intent = getIntent();
        strBMI = intent.getStringExtra("BMI");
        strWeight = intent.getStringExtra("Weight");

        program_list[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder program_info = new AlertDialog.Builder(For_UnderWeight_Program_list.this);
                program_info.setIcon(R.mipmap.ic_launcher);
                program_info.setTitle("상세정보");
                program_info.setMessage( getString(R.string.golden_six)+
                        "\n이 프로그램으로 운동을 하시겠습니까?");

                program_info.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent Golden_Six= new Intent(For_UnderWeight_Program_list.this, Golden_Six_Home.class);
                        Golden_Six.putExtra("BMI",strBMI);
                        Golden_Six.putExtra("Weight",strWeight);
                        startActivity(Golden_Six);
                    }
                });

                program_info.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                program_info.show();


            }
        });

        program_list[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder program_info = new AlertDialog.Builder(For_UnderWeight_Program_list.this);
                program_info.setIcon(R.mipmap.ic_launcher);
                program_info.setTitle("프로그램2 상세정보");
                program_info.setMessage( getString(R.string.program_underweight2)+
                        "\n이 프로그램으로 운동을 하시겠습니까?");

                program_info.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                program_info.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                program_info.show();


            }
        });


        program_list[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder program_info = new AlertDialog.Builder(For_UnderWeight_Program_list.this);
                program_info.setIcon(R.mipmap.ic_launcher);
                program_info.setTitle("프로그램3 상세정보");
                program_info.setMessage( getString(R.string.program_underweight3)+
                        "\n이 프로그램으로 운동을 하시겠습니까?");

                program_info.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                program_info.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                program_info.show();


            }
        });



    }
}
