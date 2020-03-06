package com.kingsofts.androidtutorial.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kingsofts.androidtutorial.R;

public class DemoFragment extends Fragment {
    private TextView demoTv;

    private int data = 10;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_demo, null);
        demoTv = v.findViewById(R.id.frag_demo_text_tv);
        demoTv.setText("Da duoc chinh sua " + data);
        return v;
    }

    public void updateContent(String content) {
        demoTv.setText(content);
    }


    public void setData(int data) {
        this.data = data;
        demoTv.setText(data + "");
    }
}
