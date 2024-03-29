package com.example.todolist;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class NewItemFragment extends Fragment {

	private OnNewItemAddedListener onNewItemAddedListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.new_item_fragment, container,
				false);

		final EditText myEditText = (EditText) view
				.findViewById(R.id.myEditText);

		myEditText.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_ENTER) {
					String newItem = myEditText.getText().toString();
					onNewItemAddedListener.onNewItemAdded(newItem);
					myEditText.setText("");
					return true;
				}
				return false;
			}
		});

		return inflater.inflate(R.layout.new_item_fragment, container, false);
	}

	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
		
		try{
			onNewItemAddedListener = (OnNewItemAddedListener)activity;
		}
		catch(Exception e){
			throw new ClassCastException(activity.toString() + "must implement OnNewItemAddedListener");
		}
		finally{
			
		}
	}

}
