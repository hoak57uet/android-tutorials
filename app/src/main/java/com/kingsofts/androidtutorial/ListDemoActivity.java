package com.kingsofts.androidtutorial;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ListDemoActivity extends AppCompatActivity {
    private RecyclerView listStudentRv;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Student> students = new ArrayList<>();
        students.add(new Student("Dat", 24));
        students.add(new Student("Thinh", 24));
        students.add(new Student("Thinh", 25));
        students.add(new Student("Thinh", 24));
        students.add(new Student("Thinh", 24));
        students.add(new Student("Thinh", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Dat", 27));
        students.add(new Student("Thinh", 27));

        listStudentRv = findViewById(R.id.main_list_student_rv);
//        listStudentRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listStudentRv.setLayoutManager(new GridLayoutManager(this, 3));
        //khai bao 1 adapter, truyen vao du lieu cho no
        ListStudentAdapter adapter = new ListStudentAdapter(students);
        listStudentRv.setAdapter(adapter);

        //view pager

        mViewPager = findViewById(R.id.main_vp);
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.ic_launcher);
        images.add(R.drawable.ic_flame);
        images.add(R.drawable.ic_flame);
        images.add(R.drawable.ic_flame);

        mViewPager.setAdapter(new ViewPagerAdapter(images));
    }
}
