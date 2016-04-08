package com.example.salut;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A placeholder fragment containing a simple view.
 */
public  class PlaceholderFragment extends Fragment {
	ListView mDrawerList;

    private String[] mPlanetTitles;
	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_traverse, container, false);
		
		String[] mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerList = (ListView) rootView.findViewById(R.id.left_drawer);

        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.drawer_list_item, mPlanetTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		
		
		return rootView;
	}
	
	  /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
    	if (position == 0) {
			Intent intent = new Intent(getActivity(), PiedActivity.class);
			startActivity(intent);
		}

      	if (position ==1) {
      				Intent intent = new Intent(getActivity(), ContactsActivity.class);
			startActivity(intent);
		}
     	if (position ==2) {
			Intent intent = new Intent(getActivity(), VideoActivity.class);
			startActivity(intent);
		}
     	if (position ==3) {
			Intent intent = new Intent(getActivity(), PalindromeActivity.class);
			startActivity(intent);
		}
	

    	
    	// update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mPlanetTitles[position]);
        PalindromeActivity palActivity = (PalindromeActivity)getActivity;
        palActivity.mDrawerLayout.closeDrawer(mDrawerList);
    }

}