package com.example.bilal.myapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import android.widget.AdapterView.OnItemClickListener;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Bilal on 6/29/2017.
 */

public class Home extends Fragment implements ListView.OnItemClickListener {



    private SearchView searchView;
    private ListView listView;
    private ArrayList<Event> event;
    private Listadapter listEvents;
    public DbHandler dbHandler;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        db=getActivity().openOrCreateDatabase("UolEvent",MODE_PRIVATE,null);
        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHandler = new DbHandler();

        event = dbHandler.getAllData(db);
        listEvents = new Listadapter(getActivity(), event);
        listView = (ListView) view.findViewById(R.id.mobile_list);
        listView.setAdapter(listEvents);


        listView.setOnItemClickListener(this);
        searchView=(SearchView) view.findViewById(R.id.search);
        searchView.setQueryHint("Enter Event Name");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                event.clear();
                ArrayList<Event> li = dbHandler.getSearchData(query,db);
                for (int i = 0; i < li.size(); i++) {
                    Event u = li.get(i);
                    // if(!u.getEmail().equals(mail))
                    // {
                    Log.d("sring nae from search",u.getName());
                    event.add(u);
                    //}
                }
                listEvents.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                event.clear();
                Log.d("sring out from search",newText);
                if(newText == "")
                {
                    event = dbHandler.getAllData(db);
                    listEvents.notifyDataSetChanged();

                }
                else {
                    event.clear();
                    ArrayList<Event> li = dbHandler.getSearchData(newText, db);
                    for (int i = 0; i < li.size(); i++) {
                        Event u = li.get(i);
                        // if(!u.getEmail().equals(mail))
                        // {
                        Log.d("sring in from search", u.getName());
                        event.add(u);
                        //}
                    }
                    listEvents.notifyDataSetChanged();
                }
                return true;
            }


//
//
//        String s = "[\n" +
//                "{\n" +
//                "     \"name\":SpringFest,\n" +
//                "   \"event_date\":\"12-07-2017\",\n" +
//                "       \"picture\":\"http:dummyimage.com/155*124.bmp/ff4444/ffffff\"\n" +
//                "       },\n"+
//                "{\n" +
//                "     \"name\":CulturalFest,\n" +
//                "   \"event_date\":\"12-07-2017\",\n" +
//                "    \"event_venue\":\"lahore\",\n" +
//                "      \"description\":\"welcome\",\n" +
//                "       \"picture\":\"http:dummyimage.com/155*124.bmp/ff4444/ffffff\"\n" +
//        "}\n"+
//                "]";

//        Gson gson = new Gson();
//        obj = gson.fromJson(s, Event[].class);
        });

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Intent i = new Intent(getActivity(), EventDetail.class);
        i.putExtra("name",event.get(position).getName());
        i.putExtra("date",event.get(position).getEvent_date());
        i.putExtra("venu",event.get(position).getEvent_venue());
        i.putExtra("des",event.get(position).getDescription());
        i.putExtra("pic",event.get(position).getPicture());
        startActivity(i);
    }


    }





