package com.example.salut;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter<User> {
	
	public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);    
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.contacts_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(user.getName());
        tvHome.setText(user.getCity());
        if( user.isActif())
//        	convertView.setBackgroundColor( convertView.getResources().getColor(  android.R.color.holo_orange_light) );
    	convertView.setBackgroundColor( Color.GREEN  );
        // Return the completed view to render on screen
        return convertView;
    }
}
