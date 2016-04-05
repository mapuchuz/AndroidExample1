package com.example.salut;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

/**
 * An activity representing a list of Animals. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link AnimalDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link AnimalListFragment} and the item details (if present) is a
 * {@link AnimalDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link AnimalListFragment.Callbacks} interface to listen for item selections.
 */
public class AnimalListActivity extends Activity implements AnimalListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animal_list);

		if (findViewById(R.id.animal_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((AnimalListFragment) getFragmentManager().findFragmentById(R.id.animal_list)).setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link AnimalListFragment.Callbacks} indicating that
	 * the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(AnimalDetailFragment.ARG_ITEM_ID, id);
			AnimalDetailFragment fragment = new AnimalDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction().replace(R.id.animal_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, AnimalDetailActivity.class);
			detailIntent.putExtra(AnimalDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
}
