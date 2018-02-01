/*
 * LonelyTwitterActivity
 *
 * Version 1.0
 *
 * January 30, 2018
 *
 *  Copyright © 2018 Team X. CMPUT 301 University of Alberta - All Rights Reserved.
 *  You may use, distribute or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 *  You can find a copy of the license in this project. Otherwise please contact contact@abc.ca
 */


package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * LonelyTwitterActivity
 *
 * Version 1.0
 *
 * @author cbinns
 * @see Tweet
 * @see NormalTweet
 * @see ImportantTweet
 */
public class LonelyTwitterActivity extends Activity {
	private static final String FILENAME = "tweets.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	/**
	 * Creates the Lonely Twitter Activity page
	 * Creates a list of old tweets and displays
	 *
	 * @param savedInstanceState Saved users state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("LifeCycle ---->", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);

		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * On click of the save button adds
			 * the new tweet to the list view
			 *
			 * @param v List view
			 */
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});



		// clear button lab 3

		clearButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * Clears old Tweets from list view
			 *
			 * @param v List view
			 */
			public void onClick(View v) {
				setResult(RESULT_OK);

				tweetList.clear();
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});
	}

	/**
	 * On app startup load persitent
	 * data from a file to display
	 */
	@Override
	protected void onStart() {

		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle --->", "onStart is called");

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);

	}

	/**
	 * Load old tweets to display
	 *
	 * @throws RuntimeException Exception if file not found
	 */
	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Taken https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			// 2018-01-23
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}

	}

	/**
	 * Save new tweets to file to
	 * become persitent
	 *
	 * @throws RuntimeException If file not found
	 */
	private void saveInFile() {
		try {

			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Kill the activity
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("Lifecycle", "onDestroy is called");
	}
}