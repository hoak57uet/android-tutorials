package com.kingsofts.androidtutorial.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.kingsofts.androidtutorial.R;
import com.kingsofts.androidtutorial.Student;

public class FirstActivity extends AppCompatActivity {
    private Button gotoSecondBtn;
    private EditText firstEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        gotoSecondBtn = findViewById(R.id.go_to_second_btn);
        firstEdt = findViewById(R.id.first_edt);

        gotoSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to second screen
                String text = firstEdt.getText().toString();

                Intent i = new Intent(FirstActivity.this, SecondActivity.class);
                i.putExtra("first_data", text);

                i.putExtra("default_data", "ABCZ:Y");


                Student s = new Student("Dat", 10);

                i.putExtra("data_object", s);
                FirstActivity.this.startActivity(i);
            }
        });
    }
}
