package com.example.hackprinceton;

import com.example.picgame.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BookActivity extends Activity {
	
	private final String TAG = "Book Activity";
	String title;
	TextView booktitle, author;
	LinearLayout ll;
	int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
	int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book);
		
		Bundle extras = getIntent().getExtras();
		/*if (extras != null) {
			title = extras.getString("booktitle");
			
			booktitle = (TextView) findViewById(R.id.textView3);
			author = (TextView) findViewById(R.id.textView4);
			
			booktitle.setText(title);
			author.setText("get author from booktitle"); */
		
//			we shouldn't need this
//			for (int i = 0; i < 5; i++) {
//				
//			}
//			
//		    String condition = extras.getString("condition");
//		    Log.i(TAG, condition);
//		}
		
		LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(matchParent, wrapContent);
		int gravity = Gravity.CENTER_HORIZONTAL;
		lParams.gravity = gravity;
		
		ll = (LinearLayout) findViewById(R.id.buttonlayout);
		
		// go get listings and create button for each
		for (int i = 0; i < 5; i++) {

			Button btnNew = new Button(this);
			btnNew.setText(extras.getString("condition"+i));
			btnNew.setTag("how to tag this");
	
			ll.addView(btnNew, lParams);
		}
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
	
	public void onClickBuy(View v) {
		Intent intent = new Intent(getBaseContext(), BuyActivity.class);
		startActivity(intent);
	}
	
	public void onClickSell(View v) {
		// also pass the tag to the next page
		Intent intent = new Intent(getBaseContext(), SellActivity.class);
		startActivity(intent);
	}
}