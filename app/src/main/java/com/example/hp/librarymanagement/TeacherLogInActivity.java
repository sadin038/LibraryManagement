package com.example.hp.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public
class TeacherLogInActivity extends AppCompatActivity {
    private TextView textview;
    private Button button;
    private EditText user_name_edit,password_edit;
    private int counter = 3;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_teacher_log_in);
        textview = (TextView)findViewById(R.id.warning_attempt_Id);
        button = (Button)findViewById(R.id.login_button_Id);
        user_name_edit = (EditText)findViewById(R.id.user_name_Id);
        password_edit = (EditText)findViewById(R.id.password_Id);
        textview.setText("Number of attempts remaining : 3");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_name_edit.getText().toString();
                String password = password_edit.getText().toString();

                if(username.equals("niloy") && password.equals("38"))
                {

                    Intent intent = new Intent(TeacherLogInActivity.this,TeacherHomePage.class);
                    startActivity(intent);
                }
                else
                {
                    counter--;
                    textview.setText("Number of attempts remaining : "+counter);
                    if(counter==0)
                    {
                        button.setEnabled(false);
                    }
                }
            }

        });
    }
}
