package com.example.attendance_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddStudent extends AppCompatActivity {

    private EditText studentName, gceid;
    private Button add;
    private Button delete;
    private  TextView btnvaluedatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        btnvaluedatabase = findViewById(R.id.passedclassnamedatabase);
        Intent classintent = getIntent();
        String classnamepassed = classintent.getStringExtra("Classname1");
        btnvaluedatabase.setText(classnamepassed);
        studentName = (EditText)findViewById(R.id.studentNamedatabase);
        gceid = (EditText)findViewById(R.id.mcneeseiddatabase);
        add = (Button) findViewById(R.id.addStudentdatabase);
        delete = (Button) findViewById(R.id.deleteStudentdatabase);
        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteStudent();
            }
        });



    }
    public void addStudent(){
        String studentNameValue  = studentName.getText().toString();
        String GceIdValue    = gceid.getText().toString();
        if (!TextUtils.isEmpty(studentNameValue)&&!TextUtils.isEmpty(GceIdValue)){
            String id=databaseReference.push().getKey();
            Students students =new Students(id,studentNameValue,GceIdValue);
            databaseReference.child(btnvaluedatabase.getText().toString()).child(gceid.getText().toString()).setValue(students);
            studentName.setText("");
            gceid.setText("");
            Toast.makeText(AddStudent.this,"Student details added",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(AddStudent.this,"Please fill fields",Toast.LENGTH_SHORT).show();

        }
    }
    public void deleteStudent(){
        String studentNameValue = studentName.getText().toString();
        String GceIdValue = gceid.getText().toString();

        if(!TextUtils.isEmpty(studentNameValue)&&!TextUtils.isEmpty(GceIdValue)){
            String id = databaseReference.push().getKey();
            Students students = new Students(id,studentNameValue,GceIdValue);
            databaseReference.child(btnvaluedatabase.getText().toString()).child(gceid.getText().toString()).removeValue();

            studentName.setText("");
            gceid.setText("");
            Toast.makeText(AddStudent.this,"Student Deleted",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(AddStudent.this,"Please Fill Fields",Toast.LENGTH_SHORT).show();
        }
    }
}
