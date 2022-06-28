package com.example.hp.librarymanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public
class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText rollSigUp,nameSigUp,departmentSigUp,emailSigUp,usernameSigUp,passwordSigUp;

    private Button button;

    SqliteForStudentLogin studentSignUp;



    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sign_up);

        studentSignUp = new SqliteForStudentLogin (this);

        rollSigUp = (EditText)findViewById (R.id.RollNoSignUpId);
        nameSigUp = (EditText)findViewById (R.id.StudentNameSignUpId);
        departmentSigUp = (EditText)findViewById (R.id.DepartMentSignUpId);
        emailSigUp = (EditText)findViewById (R.id.EmailSignUpId);
        usernameSigUp = (EditText)findViewById (R.id.UserNameSignUpId);
        passwordSigUp = (EditText)findViewById (R.id.PasswordSignUpId);

        button = (Button)findViewById (R.id.SignUpButtonId);

        button.setOnClickListener (this);
    }

    @Override
    public
    void onClick(View v) {

        if(v.getId ()==R.id.SignUpButtonId)
        {
            boolean checker =  studentSignUp.addtotable (rollSigUp.getText ().toString (),nameSigUp.getText ().toString (),departmentSigUp.getText ().toString (),emailSigUp.getText ().toString (),usernameSigUp.getText ().toString (),passwordSigUp.getText ().toString ());
            if(checker == true)
            {
                Toast.makeText (SignUpActivity.this,"Successfully SignUP",Toast.LENGTH_SHORT).show ();
            }
            else
            {
                Toast.makeText (SignUpActivity.this,"SignUp is not Completed",Toast.LENGTH_SHORT).show ();
            }
            rollSigUp.setText ("");
            nameSigUp.setText ("");
            departmentSigUp.setText ("");
            emailSigUp.setText ("");
            usernameSigUp.setText ("");
            passwordSigUp.setText ("");

        }

    }
}
