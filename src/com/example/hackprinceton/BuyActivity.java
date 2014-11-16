package com.example.hackprinceton;

import com.example.picgame.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyActivity extends Activity {
	
	EditText comment;
	TextView seller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
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

	public void onClick(View v){

		//get seller from listing that will be found by tag from previous page
		
		comment = (EditText)findViewById(R.id.editText1);
		seller = (TextView)findViewById(R.id.seller);
		String text = comment.getText().toString();
		String selleremail = ((String) seller.getText()) + "@princeton.edu";
		Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
		emailIntent.setData(Uri.parse("mailto:" + selleremail)); 
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "I want to buy your book");
		emailIntent.putExtra(Intent.EXTRA_TEXT, text);
		

		try {
			startActivity(Intent.createChooser(emailIntent, "Send email using..."));
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(BuyActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
		}

	}
}