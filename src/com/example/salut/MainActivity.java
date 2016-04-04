package com.example.salut;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView monTexte = (TextView) findViewById(R.id.totoMongo);
		monTexte.setText("Je me suis fait totomonguer");
		
	    // Capture our button from layout
	    Button button = (Button)findViewById(R.id.button_send);
	    // Register the onClick listener with the implementation above
	    button.setOnClickListener(mCorkyListener);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	public void sendMessage(View view) {
		Intent intent = new Intent(this, PiedActivity.class);
		startActivity(intent);
	}
	
	public void gotoPalin(View view) {
		Intent intent = new Intent(this, PalindromeActivity.class);
		startActivity(intent);	
	}
	
	public void gotoContacts(View view) {
		Intent intent = new Intent(this, ContactsActivity.class);
		startActivity(intent);	
	}
	
	public void toaster() {
		Context context = getApplicationContext();
		CharSequence text = "Hello toast!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	private void sendere() {
		Intent intent = new Intent(this, PiedActivity.class);
		startActivity(intent);
	}
	// Create an anonymous implementation of OnClickListener
	private OnClickListener mCorkyListener = new OnClickListener() {
	    public void onClick(View v) {
	      // do something when the button is clicked
			TextView monTexte = (TextView) findViewById(R.id.totoMongo);
			monTexte.setText("Je me suis encore fait clickouiller");
			
			toaster();
			
			sendere();
	    }
	};

}
