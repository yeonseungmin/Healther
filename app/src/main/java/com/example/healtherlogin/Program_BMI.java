package com.example.healtherlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Program_BMI extends AppCompatActivity {

    private final FirebaseDatabase database= FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference= database.getInstance().getReference();
    private final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private final String UID = user.getUid();

    private ImageView BMI_Image;
    private TextView BMI_View, BMI_Type_View;
    Button Calculate, Recommendation;

    double Height, Weight, Age;
    double BMI;
    String strBMI,strWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_bmi);

        BMI_View = (TextView) findViewById(R.id.BMI_View);
        BMI_Type_View = (TextView)findViewById(R.id.BMI_View_Type);
        Calculate = (Button) findViewById(R.id.Calculate);
        Recommendation = (Button) findViewById(R.id.Recommendation);
        BMI_Image = (ImageView) findViewById(R.id.BMI_Image);

        BottomNavigationView bottom_navi = findViewById(R.id.bottom_navi);
        bottom_navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.Diary){
                    Intent Diary= new Intent(Program_BMI.this, Diary_Home.class);
                    startActivity(Diary);
                }else if(item.getItemId()==R.id.Calculate){
                    Intent Calculate= new Intent(Program_BMI.this, Program.class);
                    startActivity(Calculate);
                }else if(item.getItemId()==R.id.Recommendation){
                    Toast.makeText(Program_BMI.this, "현재 화면입니다", Toast.LENGTH_SHORT).show();
                }

                return false;

            }
        });





        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("User").child(UID).child("유저정보").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User user = snapshot.getValue(User.class);
                        assert user != null;
                        strWeight=user.getweight();
                        Height= Double.parseDouble(user.getheight());
                        Weight= Double.parseDouble(strWeight);
                        Age= Double.parseDouble(user.getage());
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });
                BMI = Weight/Math.pow(Height,2)*10000;
                strBMI = String.format("%.2f",BMI);
                BMI_View.setText(strBMI);
                    if (BMI < 18.5) {
                        BMI_Type_View.setText("저체중");
                        BMI_Image.setImageResource(R.drawable.underweight);
                    } else if (BMI >= 18.5 && BMI < 23) {
                        BMI_Type_View.setText("정상");
                        BMI_Image.setImageResource(R.drawable.normal);
                    } else if (BMI >= 23 && BMI < 25) {
                        BMI_Type_View.setText("과체중");
                        BMI_Image.setImageResource(R.drawable.overweight);
                    } else if (BMI >= 25 && BMI < 30) {
                        BMI_Type_View.setText("1단계 비만");
                        BMI_Image.setImageResource(R.drawable.obesity1);
                    } else if (BMI >= 30 && BMI < 35) {
                        BMI_Type_View.setText("2단계 비만");
                        BMI_Image.setImageResource(R.drawable.obesity2);
                    } else {
                        BMI_Type_View.setText("3단계 비만(고도비만)");
                        BMI_Image.setImageResource(R.drawable.obesity3);
                    }
            }

        });

        Recommendation.setOnClickListener(new View.OnClickListener(){;
            @Override
            public void onClick(View view) {
                if(BMI>=25){
                    Intent Obese = new Intent(Program_BMI.this, For_Obese_Program_list.class);
                    Obese.putExtra("BMI",strBMI);
                    Obese.putExtra("Weight",strWeight);
                    startActivity(Obese);
                }
                else if(BMI>=18.5&&BMI<25){
                    Intent Ordinary = new Intent(Program_BMI.this, For_Ordinary_Program_list.class);
                    Ordinary.putExtra("BMI",strBMI);
                    Ordinary.putExtra("Weight",strWeight);
                    startActivity(Ordinary);
                }else if (BMI<18.5){
                    Intent UnderWeight = new Intent(Program_BMI.this, For_UnderWeight_Program_list.class);
                    UnderWeight.putExtra("BMI",strBMI);
                    UnderWeight.putExtra("Weight",strWeight);
                    startActivity(UnderWeight);
                }
            }


        });
    }

}
