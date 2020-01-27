package com.example.pixartadminpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pixartadminpanel.Model.CourseModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCourseActivity extends AppCompatActivity {

    private EditText courseId, courseCategory, course, courseDescription;
    Spinner courseName;
    private EditText courseDurationTitle, courseDurationDescription;
    private EditText courseContentTitle, courseContentDescription;
    private EditText courseSoftwareToLearnTitle, courseSoftwareToLearnDescription;
    private EditText courseCareerOptionTitle, courseCareerOptionDescription;
    private Button buttonAddCourse;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        courseId = findViewById(R.id.course_id);
        courseCategory = findViewById(R.id.course_category);
        course = findViewById(R.id.course);
        courseName = findViewById(R.id.course_name);
        courseDescription = findViewById(R.id.course_description);
        courseDurationTitle = findViewById(R.id.course_durationTitle);
        courseDurationDescription = findViewById(R.id.course_durationDescription);
        courseContentTitle = findViewById(R.id.course_contentTitle);
        courseContentDescription = findViewById(R.id.course_contentDescription);
        courseSoftwareToLearnTitle = findViewById(R.id.course_softwareToLearnTitle);
        courseSoftwareToLearnDescription = findViewById(R.id.course_softwareToLearnDescription);
        courseCareerOptionTitle = findViewById(R.id.course_careerOptionTitle);
        courseCareerOptionDescription = findViewById(R.id.course_careerOptionDescription);

        buttonAddCourse = findViewById(R.id.buttonAddCourses);

        databaseReference = FirebaseDatabase.getInstance().getReference("course");

        buttonAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String COURSE_ID = courseId.getText().toString();
                String COURSE_CATEGORY = courseCategory.getText().toString();
                String COURSE = course.getText().toString();
                String COURSE_NAME = courseName.getSelectedItem().toString();
                String COURSE_DESCRIPTION = courseDescription.getText().toString();
                String COURSE_DURATIONTITLE = courseDurationTitle.getText().toString();
                String COURSE_DURATIONDESCRIPTION = courseDurationDescription.getText().toString();
                String COURSE_CONTENTTITLE = courseContentTitle.getText().toString();
                String COURSE_CONTENTDESCRIPTION = courseContentDescription.getText().toString();
                String COURSE_SOFTWARETOLEARNTITLE = courseSoftwareToLearnTitle.getText().toString();
                String COURSE_SOFTWARETOLEARNDESCRIPTION = courseSoftwareToLearnDescription.getText().toString();
                String COURSE_CAREEROPTIONTITLE = courseCareerOptionTitle.getText().toString();
                String COURSE_CAREEROPTIONTITLEDESCRIPTION = courseCareerOptionDescription.getText().toString();

                String UID = databaseReference.push().getKey();

                CourseModel courseModel = new CourseModel(UID, COURSE_ID, COURSE_CATEGORY, COURSE, COURSE_NAME, COURSE_DESCRIPTION,
                        COURSE_DURATIONTITLE, COURSE_DURATIONDESCRIPTION, COURSE_CONTENTTITLE,
                        COURSE_CONTENTDESCRIPTION, COURSE_SOFTWARETOLEARNTITLE, COURSE_SOFTWARETOLEARNDESCRIPTION,
                        COURSE_CAREEROPTIONTITLE, COURSE_CAREEROPTIONTITLEDESCRIPTION);

                databaseReference.child(UID).setValue(courseModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Value Added",Toast.LENGTH_LONG).show();
                        }
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });

    }
}
