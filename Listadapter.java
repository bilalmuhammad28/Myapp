package com.example.bilal.myapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bilal on 7/1/2017.
 */

public class Listadapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Event> event;


    public Listadapter(Context context, ArrayList<Event> e) {
        super(context, R.layout.eventlist, e);
        this.context = context;
        this.event = e;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View eventlist = inflater.inflate(R.layout.eventlist, null,true);
        Event e = event.get(position);

        ((TextView) eventlist.findViewById(R.id.name)).setText(e.getName());
//        ((TextView) eventlist.findViewById(R.id.venue)).setText(e.getEvent_venue());
          ((TextView) eventlist.findViewById(R.id.date)).setText(e.getEvent_date());
//        ((TextView) eventlist.findViewById(R.id.des)).setText(e.getDescription());
        //((ImageView) eventlist.findViewById(R.id.pic)).setImageResource(e.getPicture());

        return eventlist;
    }
}
