package com.example.salut;

import com.example.salut.dummy.Animal;
import com.example.salut.dummy.AnimalContent;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A fragment representing a single Animal detail screen. This fragment is
 * either contained in a {@link AnimalListActivity} in two-pane mode (on
 * tablets) or a {@link AnimalDetailActivity} on handsets.
 */
public class AnimalDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private Animal mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public AnimalDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = AnimalContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_animal_detail, container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			String photo= mItem.photo;
					
			((TextView) rootView.findViewById(R.id.animal_detail)).setText(mItem.name);
			((TextView) rootView.findViewById(R.id.animal_detail_more)).setText(mItem.species);
			((ImageView)  rootView.findViewById(R.id.imageView1))
					.setImageResource( getResources().getIdentifier(photo, 
							"drawable", 
							"com.example.salut"
							) );
		}

		return rootView;
	}
}
