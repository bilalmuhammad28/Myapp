package com.example.bilal.myapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=openOrCreateDatabase("UolEvent",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS login"+"(userName TEXT PRIMARY KEY,password TEXT );");
        String query="CREATE TABLE IF NOT EXISTS Event( name TEXT PRIMARY KEY,date TEXT,venue TEXT,description TEXT,picture TEXT);";
        db.execSQL(query);

//        db.execSQL("INSERT INTO Event VALUES('Spring Festival','09-12-2017', 'Lahore', 'Welcome', 'e1');");
//        db.execSQL("INSERT INTO Event VALUES('Cultutal Festival','09-12-2017', 'Lahore', 'Welcome', 'e2');");
//       db.execSQL("INSERT INTO Event VALUES('Drama Festival','09-12-2017', 'Lahore', 'Welcome', 'e3');");
//        db.execSQL("INSERT INTO Event VALUES('lok mela','09-12-2017', 'lahore', 'Welcome', 'e4');");
//        db.execSQL("INSERT INTO Event VALUES('sports week','09-12-2017', 'Lahore', 'Welcome', 'e5');");
//        db.execSQL("INSERT INTO Event VALUES('Drama ','09-12-2017', 'Lahore', 'Welcome', 'e6');");
//
//


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Login s = new Login();
        fragmentTransaction.add(R.id.main_frame, s);
        fragmentTransaction.commit();

    }
}
