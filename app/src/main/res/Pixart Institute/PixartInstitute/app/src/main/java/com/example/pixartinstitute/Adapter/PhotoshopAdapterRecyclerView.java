package com.example.pixartinstitute.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixartinstitute.Model.CourseModel;
import com.example.pixartinstitute.R;

import java.util.List;

public class PhotoshopAdapterRecyclerView extends RecyclerView.Adapter<PhotoshopAdapterRecyclerView.MyViewHolder> {

    Context context;
    List<CourseModel> list;

    public PhotoshopAdapterRecyclerView(Context context, List<CourseModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.layout_photoshop, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.uid.setText(list.get(position).getUid());
        holder.courseId.setText(list.get(position).getCourseId());
        holder.courseCategory.setText(list.get(position).getCourseCategory());
        holder.course.setText(list.get(position).getCourse());
        holder.courseName.setText(list.get(position).getCourseName());
        holder.courseDescription.setText(list.get(position).getCourseDescription());
        holder.courseDurationTitle.setText(list.get(position).getCourseDurationTitle());
        holder.courseDurationDescription.setText(list.get(position).getCourseDurationDescription());
        holder.courseContentTitle.setText(list.get(position).getCourseContentTitle());
        holder.courseContentDescription.setText(list.get(position).getCourseContentDescription());
        holder.courseSoftwareToLearnTitle.setText(list.get(position).getCourseSoftwareToLearnTitle());
        holder.courseSoftwareToLearnDescription.setText(list.get(position).getCourseSoftwareToLearnDescription());
        holder.courseCareerOptionTitle.setText(list.get(position).getCourseCareerOptionTitle());
        holder.courseCareerOptionDescription.setText(list.get(position).getCourseCareerOptionDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView uid;
        TextView courseId;
        TextView courseCategory;
        TextView course;
        TextView courseName;
        TextView courseDescription;
        TextView courseDurationTitle;
        TextView courseDurationDescription;
        TextView courseContentTitle;
        TextView courseContentDescription;
        TextView courseSoftwareToLearnTitle;
        TextView courseSoftwareToLearnDescription;
        TextView courseCareerOptionTitle;
        TextView courseCareerOptionDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            uid = (TextView) itemView.findViewById(R.id.txt_UID);
            courseId = (TextView) itemView.findViewById(R.id.txt_courseID);
            courseCategory = (TextView) itemView.findViewById(R.id.txt_courseCategory);
            course = (TextView) itemView.findViewById(R.id.txt_course);
            courseName = (TextView) itemView.findViewById(R.id.txt_courseName);
            courseDescription = (TextView) itemView.findViewById(R.id.txt_courseDescription);
            courseDurationTitle = (TextView) itemView.findViewById(R.id.txt_courseDurationTitle);
            courseDurationDescription = (TextView) itemView.findViewById(R.id.txt_courseDurationDescription);
            courseContentTitle = (TextView) itemView.findViewById(R.id.txt_courseContentTitle);
            courseContentDescription = (TextView) itemView.findViewById(R.id.txt_courseContentDescription);
            courseSoftwareToLearnTitle = (TextView) itemView.findViewById(R.id.txt_courseSoftwareToLearnTitle);
            courseSoftwareToLearnDescription = (TextView) itemView.findViewById(R.id.txt_courseSoftwareToLearnDescription);
            courseCareerOptionTitle = (TextView) itemView.findViewById(R.id.txt_coursecareerOptionTitle);
            courseCareerOptionDescription = (TextView) itemView.findViewById(R.id.txt_coursecareerOptionDescription);

        }
    }
}
