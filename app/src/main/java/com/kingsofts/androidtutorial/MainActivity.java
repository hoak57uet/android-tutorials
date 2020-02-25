package com.kingsofts.androidtutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEt;
    private EditText passwordEt;
    private TextView loginTv;
    private TextView resultTv;
    private TextView usernameErrTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //logic cua man hinh
        usernameEt = findViewById(R.id.login_username_et);
        passwordEt = findViewById(R.id.login_password_et);
        loginTv = findViewById(R.id.login_action_tv);
        resultTv = findViewById(R.id.login_result_tv);
        usernameErrTv = findViewById(R.id.login_username_err_tv);

        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionLogin();
            }
        });

    }

    private void actionLogin() {
        String username = usernameEt.getText().toString();
        String password = passwordEt.getText().toString();
        // kiem tra neu username hoac password trong
        if (username == null || username.equals("")) {
            usernameErrTv.setText("User name không được để trống!");
            return;
        }
        if (password == null || password.equals("")) {
            passwordEt.setError("Password không được để trống !!!");
            return;
        }
        //login thanh cong
        //.......
        resultTv.setText("Chúc mừng.\nBạn đã đăng nhập thành công với tên " + username);
    }
}
