package com.example.hp.librarymanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public
class AddBookActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText id,bname,wname,date;
    private Button button;
    SQliteForBookListTable bookListTable;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_book);
        bookListTable = new SQliteForBookListTable (this);

        id = (EditText)findViewById (R.id.BookIdAddId);
        bname = (EditText)findViewById (R.id.BookNameAddId);
        wname = (EditText)findViewById (R.id.WritterNameAddId);
        date = (EditText)findViewById (R.id.DateId);
        button = (Button)findViewById (R.id.AddButtonId);

        button.setOnClickListener (this);
    }

    @Override
    public
    void onClick(View v) {
        if(v.getId ()==R.id.AddButtonId)
        {
            boolean checker =  bookListTable.addtotable (id.getText ().toString (),bname.getText ().toString (),wname.getText ().toString (),date.getText ().toString ());
            if(checker == true)
            {
                Toast.makeText (AddBookActivity.this,"Successfully Book Added",Toast.LENGTH_SHORT).show ();
            }
            else
            {
                Toast.makeText (AddBookActivity.this,"Book is not Added",Toast.LENGTH_SHORT).show ();
            }
            id.setText ("");
            bname.setText ("");
            wname.setText ("");
            date.setText ("");

        }
    }
}
