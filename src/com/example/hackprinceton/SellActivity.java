package com.example.hackprinceton;

import com.example.picgame.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class SellActivity extends Activity {
	
	private final String TAG = "Sell Activity";
	private int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
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
	
	public void onClick(View v) {
		Intent intent = new Intent(getApplicationContext(), BookActivity.class);
		String condition = null;
		
		RadioButton rb;
		rb = (RadioButton) findViewById(R.id.radioButton1);
		if (rb.isChecked()) condition = "Excellent";
		rb = (RadioButton) findViewById(R.id.radioButton2);
		if (rb.isChecked()) condition = "Very Good";
		rb = (RadioButton) findViewById(R.id.radioButton3);
		if (rb.isChecked()) condition = "Good";
		rb = (RadioButton) findViewById(R.id.radioButton4);
		if (rb.isChecked()) condition = "Poor";
		rb = (RadioButton) findViewById(R.id.radioButton5);
		if (rb.isChecked()) condition = "why am i even selling this";
		
		EditText price = (EditText)findViewById(R.id.editText1);
		condition = condition + " - $" + price.getText().toString();

		Log.i(TAG, "condition obtained");
		
		intent.putExtra("condition" + count, condition);
		startActivity(intent);
		count++;
	}
}