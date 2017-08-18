//package com.example.bilal.myapp;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.provider.CalendarContract;
//import android.provider.ContactsContract;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Bilal on 16-Aug-17.
// */
//
//public class DatabaseHandler  {
//
//    private static final int DATABASE_VERSION = 1;
//
//    //Database name
//    private static final String DATABASE_NAME = "appuol";
//
//    //Table name
//    private static final String TABLE_EVENTS = "events";
//
//
//    //Table colums name
//    private static final String KEY_NAME = "name";
//    private  static  final String KEY_EVENT_DATE= "event_date";
//    private  static  final String KEY_EVENT_VENUE= "event_venue";
//    private  static  final String KEY_DESCRIPTION= "description";
//    private  static  final String KEY_PICTURE= "picture";
//
//
//    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//
//    //Creating database
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String CREATE_EVENTS_TABLE = "CREATE TABLE " + TABLE_EVENTS + "("
//                + KEY_NAME + "TEXT PRIMARY KEY," + KEY_EVENT_DATE + " TEXT,"
//                + KEY_EVENT_VENUE + " TEXT," + KEY_DESCRIPTION +"TEXT," +KEY_PICTURE +"TEXT,"+ ")";
//        db.execSQL(CREATE_EVENTS_TABLE);
//    }
//
//    // UPGRADE DATABASE
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//        // Drop older table if existed
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
//
//        // Create tables again
//        onCreate(db);
//    }
//
//    // Adding new contact
//    public void addEvent(Event event) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues v = new ContentValues();
//        v.put(KEY_NAME, event.getName());
//        v.put(KEY_EVENT_DATE, event.getEvent_date());
//        v.put(KEY_EVENT_VENUE,event.getEvent_venue());
//        v.put(KEY_DESCRIPTION,event.getDescription());
//        v.put(KEY_PICTURE,event.getPicture());
//
//
//        // Inserting Row
//        db.insert(TABLE_EVENTS, null, v);
//        db.close(); // Closing database connection
//    }
//
//    // Getting single contact
//    public Event getEvent(String name) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_EVENTS, new String[] {
//                        KEY_NAME, KEY_EVENT_DATE }, KEY_NAME + "=?",
//                new String[] { String.valueOf(name) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//             Event e = new Event(cursor.getString(0));
//        return e;
//
//    // Getting All Events
//
//    public List<Event> getAllEvents() {
//        List<Event> contactList = new ArrayList<Event>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_EVENTS;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//       // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                Event e = new Event();
//                e.setName(cursor.getString(0));
//                e.setEvent_venue(cursor.getString(1));
//                e.setEvent_date(cursor.getString(2));
//                e.setDescription(cursor.getString(3));
//                e.setPicture(cursor.getString(4));
//                // Adding contact to list
//                contactList.add(e);
//            } while (cursor.moveToNext());
//        }
//        // return contact list
//        return contactList;
//    }
//    public int getEventsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_EVENTS;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        // return count
//        return cursor.getCount();
//    }
//    //update database
//    public int updateContact(Event event) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, event.getName());
//        values.put(KEY_EVENT_DATE, event.getEvent_date());
//        values.put(KEY_EVENT_VENUE, event.getEvent_venue());
//        values.put(KEY_DESCRIPTION, event.getDescription());
//        values.put(KEY_PICTURE, event.getPicture());
//        // updating row
//        return db.update(TABLE_EVENTS, values, KEY_NAME + " = ?",
//                new String[] { String.valueOf(event.getName()) });
//
//    }
//}
