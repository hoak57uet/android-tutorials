package com.kingsofts.androidtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListStudentAdapter extends RecyclerView.Adapter<ListStudentAdapter.ViewHolder> {
    private List<Student> students = new ArrayList<>();

    public ListStudentAdapter(List<Student> students) {
        this.students = students;
    }

    /**
     * Khai báo layout để bơm dữ liệu vào
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false));
    }

    /**
     * Khai báo cách bơm dữ liệu
     *
     * @param holder
     * @param position : thứ tự của dữ liệu nằm trong danh sách
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.itemStudentNameTv.setText(student.getName());
        holder.itemStudentAgeTv.setText(student.getAge() + "");
        holder.itemTimeTv.setText("22/12");
        if (position % 3 == 0) {
            holder.itemView.setBackgroundColor(R.color.colorAccent);
        } else {
            if (position % 3 == 1)
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), android.R.color.holo_blue_bright));
            else holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), android.R.color.holo_red_dark));
        }

    }

    // khai báo số lượng các phần tử con của list đó
    @Override
    public int getItemCount() {
        return students.size();
    }

    // khai báo các view nằm trong layout, kéo về để xử lý dữ liệu
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemStudentNameTv;
        TextView itemStudentAgeTv;
        TextView itemTimeTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemStudentNameTv = itemView.findViewById(R.id.item_student_name_tv);
            itemStudentAgeTv = itemView.findViewById(R.id.item_student_age_tv);
            itemTimeTv = itemView.findViewById(R.id.item_student_time_tv);
        }
    }
}
