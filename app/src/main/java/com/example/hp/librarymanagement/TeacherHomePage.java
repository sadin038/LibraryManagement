package com.example.hp.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public
class TeacherHomePage extends AppCompatActivity implements View.OnClickListener{

    private Button displayButton,deleteButton,addBook,viewBook;


    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_teacher_home_page);


        displayButton = (Button)findViewById (R.id.displayAllDataId);
        deleteButton = (Button)findViewById (R.id.deleteAnyDataId);
        addBook = (Button)findViewById (R.id.addBookId);
        viewBook = (Button)findViewById (R.id.viewAllBookId);

        displayButton.setOnClickListener (this);
        deleteButton.setOnClickListener (this);
        addBook.setOnClickListener (this);
        viewBook.setOnClickListener (this);

    }

    @Override
    public
    void onClick(View v) {
        if(v.getId ()==R.id.displayAllDataId)
        {
            Intent intent = new Intent(TeacherHomePage.this,DisplayAllStudentInformation.class);
            startActivity(intent);

        }

        if(v.getId ()==R.id.deleteAnyDataId)
        {
            Intent intent = new Intent(TeacherHomePage.this,DeleteAnyInformationActivity.class);
            startActivity(intent);
        }
        if(v.getId ()==R.id.addBookId)
        {
            Intent intent = new Intent(TeacherHomePage.this,AddBookActivity.class);
            startActivity(intent);

        }
        if(v.getId ()==R.id.viewAllBookId)
        {
            Intent intent = new Intent(TeacherHomePage.this,ViewAllBookItem.class);
            startActivity(intent);

        }
    }
}
