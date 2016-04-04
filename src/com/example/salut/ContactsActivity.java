package com.example.salut;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ContactsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);

		/*
		 * ArrayAdapter<String> adapter = new
		 * ArrayAdapter<String>(list.getContext(), R.layout.contacts_item,
		 * R.id.item); adapter.add("toto"); adapter.add("tutu");
		 * adapter.add("titi"); adapter.add("tata"); list.setAdapter( adapter );
		 */

		/* creer users */
		User u1 = new User("toto", "Paris", "0445786545");
		User u2 = new User("tata", "Montpellier", "0555555545");
		User u3 = new User("tutu", "Toulouse", "3445786545");
		User u4 = new User("titi", "Narbonne", "666686545");
		User u5 = new User("tyty", "Barcelonne", "0315487562");

		ListView list = (ListView) findViewById(R.id.listecontacts);

		// ArrayAdapter<User> adapter = new
		// ArrayAdapter<User>(list.getContext(), R.layout.contacts_item,
		// R.id.item);
		// adapter.add(u1);
		// adapter.add(u2);
		// adapter.add(u3);
		// adapter.add(u4);
		// adapter.add(u5);

		// Construct the data source
		ArrayList<User> arrayOfUsers = new ArrayList<User>();
		// Create the adapter to convert the array to views
		final UserAdapter adapter = new UserAdapter(this, arrayOfUsers);
		// Attach the adapter to a ListView
		// ListView listView = (ListView) findViewById(R.id.lvItems);
		list.setAdapter(adapter);
		adapter.add(u1);
		adapter.add(u2);
		adapter.add(u3);
		adapter.add(u4);
		adapter.add(u5);
		//
		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        // When clicked, show a toast with the TextView text or do whatever you need.
//		        Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
		    	Intent intent = new Intent(ContactsActivity.this, DetailsActivity.class);
		    	intent.putExtra("user_current", adapter.getItem(position) );
				startActivity(intent);
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contacts, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
