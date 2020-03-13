package com.example.attendance_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class TakeAttendance extends AppCompatActivity {
    private EditText takeAttendence;
    private Button attendenceBtn;
    private TextView btnvaluedatabase;
    private TextView tvCounter;

    private TextView mDisplayDate;
    private  int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        String date = month+1 + "-" + day + "-" + year;

        mDisplayDate.setText(date);
        btnvaluedatabase = findViewById(R.id.classnamepassedtakeattendence);
        Intent classintent = getIntent();
        String classnamepassed = classintent.getStringExtra("Classname1");
        btnvaluedatabase.setText(classnamepassed);
        tvCounter = findViewById(R.id.tvcounter);
        takeAttendence = findViewById(R.id.takeattendence);
        attendenceBtn = findViewById(R.id.attendencebtn);
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("students");
        ref.child(btnvaluedatabase.getText().toString()).orderByChild("gceId").equalTo(takeAttendence.getText().toString());
        final   DatabaseReference toPath = FirebaseDatabase.getInstance()
                .getReference("Attendence")
                .child(btnvaluedatabase.getText().toString())
                .child("Date = "+date)
                .child(takeAttendence.getText().toString());
        attendenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child(btnvaluedatabase.getText().toString()).orderByChild("gceId").equalTo(takeAttendence.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                    if(dataSnapshot.exists()) {
                        final ValueEventListener valueEventListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                toPath.child(takeAttendence.getText().toString()).setValue(dataSnapshot.getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isComplete()) {
                                            takeAttendence.setText("");
                                        } else {
                                        }
                                    }
                                });
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        };
                        ref.child(btnvaluedatabase.getText().toString()).child(takeAttendence.getText().toString()).addListenerForSingleValueEvent(valueEventListener);
                        counter = counter + 1;
                        tvCounter.setText(String.valueOf(counter));
                        Toast.makeText(TakeAttendance.this,"Attendance Recorded",Toast.LENGTH_SHORT).show();

                    }
                    else{
                                Toast.makeText(TakeAttendance.this,"Invalid",Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                                public void onCancelled(@NonNull DatabaseError databaseError){
                    }

                });
            }
        });

    }
}
