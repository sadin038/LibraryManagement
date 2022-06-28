package com.example.hp.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public
class OpeningLibraryManagementApp extends AppCompatActivity {

    private ProgressBar progressbar;
    private int progress ;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_opening_library_management_app);
        progressbar = (ProgressBar)findViewById(R.id.progressbarId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                do_work();
                start_App();
            }
        });
        thread.start();
    }

    public void do_work()
    {
        for(progress=20;progress<=100;progress=progress+20)
        {
            try {
                Thread.sleep(1000);
                progressbar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void start_App()
    {
        Intent intent = new Intent(OpeningLibraryManagementApp.this,HomePage.class);
        startActivity(intent);
        finish();
    }
}
