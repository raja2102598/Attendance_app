package com.example.attendance_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class std_login extends AppCompatActivity {

    EditText mrno;
    Button sloginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_login);
        mrno = findViewById(R.id.r_no);
        sloginbtn =findViewById(R.id.sloginBtn);

        sloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rno=mrno.getText().toString().trim();
                if (TextUtils.isEmpty(rno))
                {
                    mrno.setError("Register number is required");
                }
                if(mrno.length() <12)
                {
                    mrno.setError("Register number should be equal to 12 digits");
                }

            }
        });

    }
}
