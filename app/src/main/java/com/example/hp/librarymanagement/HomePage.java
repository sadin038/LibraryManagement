package com.example.hp.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public
class HomePage extends AppCompatActivity implements View.OnClickListener{

    private Button studentButton,teacherButton;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home_page);

        studentButton = (Button)findViewById (R.id.StudentId);
        teacherButton = (Button)findViewById (R.id.TeacherId);

        studentButton.setOnClickListener (this);
        teacherButton.setOnClickListener (this);
    }

    @Override
    public
    void onClick(View v) {

        if(v.getId ()==R.id.StudentId)
        {
            Intent intent = new Intent (HomePage.this,LoginStudentActivity.class);
            startActivity (intent);
        }
        else if(v.getId ()==R.id.TeacherId)
        {
            Intent intent = new Intent (HomePage.this,TeacherLogInActivity.class);
            startActivity (intent);
        }

    }
}
