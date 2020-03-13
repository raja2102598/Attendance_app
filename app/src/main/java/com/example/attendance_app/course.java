package com.example.attendance_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class course extends AppCompatActivity {

    private Button btnip,btnmc,btncd,btnai;
    int request_code=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        btnip =findViewById(R.id.ipbtn);
        btnmc =findViewById(R.id.mcbtn);
        btnai =findViewById(R.id.aibtn);
        btncd =findViewById(R.id.cdbtn);
        btnip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextClassname = btnip.getText().toString();
                Intent classintent = new Intent(getApplicationContext(),staff_home.class);
                classintent.putExtra("Classname",TextClassname);
                startActivityForResult(classintent,request_code);

            }
        });
        btnmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextClassname = btnmc.getText().toString();
                Intent classintent = new Intent(getApplicationContext(),staff_home.class);
                classintent.putExtra("Classname",TextClassname);
                startActivityForResult(classintent,request_code);

            }
        });
        btnai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextClassname = btnai.getText().toString();
                Intent classintent = new Intent(getApplicationContext(),staff_home.class);
                classintent.putExtra("Classname",TextClassname);
                startActivityForResult(classintent,request_code);

            }
        });
        btncd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextClassname = btncd.getText().toString();
                Intent classintent = new Intent(getApplicationContext(),staff_home.class);
                classintent.putExtra("Classname",TextClassname);
                startActivityForResult(classintent,request_code);

            }
        });
    }
}
