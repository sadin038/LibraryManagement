package com.example.hp.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public
class DeleteAnyInformationActivity extends AppCompatActivity {

    private EditText edit;
    private Button button;
    SqliteForStudentLogin my;


    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_delete_any_information);

        my = new SqliteForStudentLogin (this);
        edit = (EditText)findViewById (R.id.edittextId);
        button = (Button)findViewById (R.id.deleteId);

        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public
            void onClick(View v) {

                int checker =  my.delete (edit.getText ().toString ());
                if(checker>0)
                {
                    Toast.makeText (DeleteAnyInformationActivity.this,"Successfully deleted",Toast.LENGTH_SHORT).show ();
                }
                else
                {
                    Toast.makeText (DeleteAnyInformationActivity.this,"Data is not deleted",Toast.LENGTH_SHORT).show ();
                }

            }
        });






    }
}
