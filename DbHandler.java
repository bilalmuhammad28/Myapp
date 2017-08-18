package com.example.bilal.myapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Bilal on 16-Aug-17.
 */

public class DbHandler {

    public ArrayList<Event> getAllData(SQLiteDatabase db) {
        ArrayList<Event> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM Event", null);
        if (c.getCount() != 0) {
            c.moveToFirst();
            for (int j = 0; j < c.getCount(); j++) {
                Event e = new Event();
                e.setName(c.getString(0));
                e.setEvent_date(c.getString(1));
                e.setEvent_venue(c.getString(2));
                e.setDescription(c.getString(3));
                e.setPicture(c.getString(4));
                list.add(e);
                c.moveToNext();
            }

        }
        return list;
    }

    public ArrayList<Event> getSearchData( String s, SQLiteDatabase db) {
        s= s+'%';
        ArrayList<Event> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM Event where name LIKE '" + s + "' ", null);
        if (c.getCount() != 0) {
            c.moveToFirst();
            for (int j = 0; j < c.getCount(); j++) {
                Event e = new Event();
                e.setName(c.getString(0));
                e.setEvent_date(c.getString(1));
                e.setEvent_venue(c.getString(2));
                e.setDescription(c.getString(3));
                e.setPicture(c.getString(4));
                list.add(e);
                c.moveToNext();
            }

        }
        return list;
    }

    public Event getSingleData(SQLiteDatabase db, String name) {
        Event e = new Event();
        ArrayList<Event> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM Event where = '" + name + "' ", null);
        if (c.getCount() != 0) {
            c.moveToFirst();
            e.setName(c.getString(0));
            e.setEvent_date(c.getString(1));
            e.setEvent_venue(c.getString(2));
            e.setDescription(c.getString(3));
            e.setPicture(c.getString(4));
        }
        return e;
    }

    public boolean insertRecord(SQLiteDatabase db, Event e) {
        try {
            db.execSQL("INSERT INTO Event VALUES('" + e.getName() + "','" + e.getEvent_date() + "', '" + e.getEvent_venue() + "', '" + e.getDescription() + "', '" + e.getPicture() + "');");
            return true;
        } catch (Exception exp) {
            return false;
        }
    }
//
//    public Bitmap getReportPicture(long reportId) {
//        String picturePath = getReportPicturePath(reportId);
//        if (picturePath == null || picturePath.length() == 0)
//            return (null);
//        Bitmap reportPicture = BitmapFactory.decodeFile(picturePath);
//        return (reportPicture);
//    }

//    /**
//     * Gets the path of the picture for the specified report in the database.
//     *
//     * @param reportId the identifier of the report for which to get the picture.
//     *
//     * @return the picture for the report, or null if no picture was found.
//     */
//    private String getReportPicturePath(long reportId) {
//        // Gets the database in the current database helper in read-only mode
//        SQLiteDatabase db = g;
//
//        // After the query, the cursor points to the first database row
//        // returned by the request
//        Cursor reportCursor = db.query(ReportContract.TABLE_NAME,
//                null,
//                ReportContract.ReportEntry._ID + "=?",
//                new String[]{String.valueOf(reportId)},
//                null,
//                null,
//                null);
//        reportCursor.moveToNext();
//
//        // Get the path of the picture from the database row pointed by
//        // the cursor using the getColumnIndex method of the cursor.
//        String picturePath = reportCursor.getString(reportCursor.
//                getColumnIndex(ReportContract.ReportEntry.COLUMN_PICTURE_TITLE));
//
//        return (picturePath);
//    }
}
