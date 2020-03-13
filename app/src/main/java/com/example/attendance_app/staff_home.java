package com.example.attendance_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class staff_home extends AppCompatActivity {

    Button mAdd,mAtten;
    private TextView btnvalue;
    int request_code =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);
        mAdd = findViewById(R.id.addstnbtn);
        mAtten = findViewById(R.id.stdatn);
        btnvalue = findViewById(R.id.passedclassname);
        Intent classintent = getIntent();
        String classnamepassed = classintent.getStringExtra("Classname");
        btnvalue.setText(classnamepassed);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextClassname = btnvalue.getText().toString();
                Intent classintent = new Intent(getApplicationContext(),AddStudent.class);
                classintent.putExtra("Classname1",TextClassname);
                startActivityForResult(classintent,request_code);
            }
        });
        mAtten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextClassname = btnvalue.getText().toString();
                Intent classintent = new Intent(getApplicationContext(),TakeAttendance.class);
                classintent.putExtra("Classname1",TextClassname);
                startActivityForResult(classintent,request_code);
            }
        });



    }
}
