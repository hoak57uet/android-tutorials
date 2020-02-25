package com.kingsofts.androidtutorial.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kingsofts.androidtutorial.R;
import com.kingsofts.androidtutorial.Student;

public class SecondActivity extends AppCompatActivity {
    private TextView secondTv;
    private TextView secondDefaultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondTv = findViewById(R.id.second_tv);
        secondDefaultTv = findViewById(R.id.second_default_tv);


        //get data
//        String data = getIntent().getStringExtra("first_data");
//        secondTv.setText(data);
//
//        String defaultData = getIntent().getStringExtra("default_data");
//        secondDefaultTv.setText(defaultData);

        Student student = (Student) getIntent().getSerializableExtra("data_object");
        secondTv.setText(student.getName());
        secondDefaultTv.setText(student.getAge() + "");

        findViewById(R.id.second_back_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.this.finish();
            }
        });
    }
}
