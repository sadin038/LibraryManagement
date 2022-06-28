package com.example.hp.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public
class LoginStudentActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText usernamelogin,passwordlogin;
    private Button signinbutton,signupbutton;


    SqliteForStudentLogin studentLogin;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login_student);

        studentLogin = new SqliteForStudentLogin (this);


        usernamelogin = (EditText)findViewById (R.id.UserNameLoginId);
        passwordlogin = (EditText)findViewById (R.id.PasswordLoginId);
        signinbutton = (Button)findViewById (R.id.SignInLoginId);
        signupbutton = (Button)findViewById (R.id.SignUpLoginId);

        signinbutton.setOnClickListener (this);
        signupbutton.setOnClickListener (this);




    }

    @Override
    public
    void onClick(View v) {

        String username = usernamelogin.getText ().toString ();
        String password = passwordlogin.getText ().toString ();


        if (v.getId ()==R.id.SignUpLoginId)
        {
            Intent intent = new Intent (LoginStudentActivity.this,SignUpActivity.class);
            startActivity (intent);
        }

        if(v.getId ()==R.id.SignInLoginId)
        {
            boolean result = studentLogin.checkLogin (username,password);

            if(result == true)
            {
                Intent intent = new Intent (LoginStudentActivity.this,StudentHomePageActivity.class);
                startActivity (intent);
            }
            else
            {
                Toast.makeText (LoginStudentActivity.this,"Wrong UserName Or Password",Toast.LENGTH_SHORT).show ();

            }



        }

    }
}
