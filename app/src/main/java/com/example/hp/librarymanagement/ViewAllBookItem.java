package com.example.hp.librarymanagement;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public
class ViewAllBookItem extends AppCompatActivity {

    private TextView text;
    SQliteForBookListTable sQliteForBookListTable;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_view_all_book_item);

        sQliteForBookListTable = new SQliteForBookListTable (this);
        text = (TextView)findViewById (R.id.textViewAllBookId);

        Cursor result = sQliteForBookListTable.display ();
        if(result.getCount () == 0)
        {
            Toast.makeText (this,"No data is found",Toast.LENGTH_SHORT).show ();
            return;
        }

        result.moveToFirst ();
        StringBuffer buffer = new StringBuffer ();

        do{

            buffer.append ("\nBOOK ID: "+result.getString (0));
            buffer.append ("\nBOOK NAME: "+result.getString (1));
            buffer.append ("\nWRITER NAME: "+result.getString (2));
            buffer.append ("\nDATE: "+result.getString (3) + "\n");


        }
        while(result.moveToNext ());
        Displaydata (buffer.toString());

    }

    public void Displaydata(String data)
    {
        text.setText (data);

    }
}
