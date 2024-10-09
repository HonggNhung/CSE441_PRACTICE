package com.example.btth3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;
    private Context context;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.idTextView.setText(student.getId());
        holder.fullNameTextView.setText(student.getFullName());
        holder.gpaTextView.setText(String.valueOf(student.getGpa()));

        // Set ảnh đại diện theo giới tính
        if (student.getGender().equals("Nam")) {
            holder.genderImageView.setImageResource(R.drawable.ic_male);
        } else {
            holder.genderImageView.setImageResource(R.drawable.ic_female);
        }

        // Thiết lập sự kiện click cho mỗi item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, StudentDetailActivity.class);
            intent.putExtra("id", student.getId());
            // Thêm các thông tin khác nếu cần
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView idTextView;
        TextView fullNameTextView;
        TextView gpaTextView;
        ImageView genderImageView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.idTextView);
            fullNameTextView = itemView.findViewById(R.id.fullNameTextView);
            gpaTextView = itemView.findViewById(R.id.gpaTextView);
            genderImageView = itemView.findViewById(R.id.genderImageView);
        }
    }
}
