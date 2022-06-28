package com.example.hp.librarymanagement;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public
class DisplayAllStudentInformation extends AppCompatActivity {

    private TextView text;
    SqliteForStudentLogin my;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_display_all_student_information);

        my = new SqliteForStudentLogin (this);
        text = (TextView)findViewById (R.id.textViewId);

        Cursor result = my.display ();
        if(result.getCount () == 0)
        {
            Toast.makeText (this,"No data is found",Toast.LENGTH_SHORT).show ();
            return;
        }

        result.moveToFirst ();
        StringBuffer buffer = new StringBuffer ();

        do{

            buffer.append ("\nROLL NO: "+result.getString (0));
            buffer.append ("\nNAME: "+result.getString (1));
            buffer.append ("\nDEPARTMENT: "+result.getString (2));
            buffer.append ("\nEMAIL: "+result.getString (3) );
            buffer.append ("\nUSERNAME: "+result.getString (4));
            buffer.append ("\nPASSWORD: "+result.getString (5) + "\n");


        }
        while(result.moveToNext ());
        Displaydata (buffer.toString());



    }

    public void Displaydata(String data)
    {
        text.setText (data);

    }
}
