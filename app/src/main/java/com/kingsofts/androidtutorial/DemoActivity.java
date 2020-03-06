package com.kingsofts.androidtutorial;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.kingsofts.androidtutorial.fragments.Demo2Fragment;
import com.kingsofts.androidtutorial.fragments.DemoFragment;

//Et, btn, img, tv
public class DemoActivity extends AppCompatActivity {
    private EditText firstNumberEt;
    private EditText secondNumberEt;
    private Button resultBtn;
    private TextView resultTv;
    private Button gotoFragmentBtn;

    private Demo2Fragment demo2Fragment;
    private DemoFragment demoFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        demoFragment = new DemoFragment();
        demo2Fragment = new Demo2Fragment();

        firstNumberEt = findViewById(R.id.demo_first_number_et);
        secondNumberEt = findViewById(R.id.demo_second_number_et);
        resultBtn = findViewById(R.id.demo_action_add_btn);
        resultTv = findViewById(R.id.demo_result_tv);
        gotoFragmentBtn = findViewById(R.id.demo_goto_frg_2_btn);

        gotoFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoFragment.updateContent("zzzzz");
            }
        });

        demoFragment.setData(1001);

        FragmentTransaction fgTx = getSupportFragmentManager().beginTransaction();
        fgTx.add(R.id.fragment_container, demoFragment);
//        fgTx.add(R.id.fragment_container, new Demo2Fragment());
        fgTx.commit();

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNum = Integer.parseInt(firstNumberEt.getText().toString());
                int secondNum = Integer.parseInt(secondNumberEt.getText().toString());

                int result = firstNum * secondNum;

                resultTv.setText(result + "");

                Log.e("=============>First: ", firstNum + "");
                Log.e("=============>Second: ", secondNum + "");
                Log.e("=============>Result: ", result + "");
            }
        });

    }
}
