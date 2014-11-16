package com.example.hackprinceton;

import com.example.picgame.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class CourseActivity extends Activity {

	private final String TAG = "Course Activity";
	TextView nameOut, course, title, author;
	int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
	int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;
	LinearLayout llMain;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);

		// creating LayoutParams with width and height defined by content
		LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(matchParent, wrapContent);
		// a variable to store alignment, will be LEFT by default
		int gravity = Gravity.CENTER_HORIZONTAL;
		int textgravity = Gravity.LEFT;
		// put the received alignment value into LayoutParams
		lParams.gravity = gravity;

		// get books from class
		
		for (int i = 0; i < 5; i++) {

			TableLayout table = new TableLayout(this);
			table.setPadding(5, 5, 5, 5);
			
			if (i % 2 == 0) table.setBackgroundColor(0xffBFEFFF);
			else table.setBackgroundColor(0xffE6E6FF);
			
			llMain = (LinearLayout) findViewById(R.id.linearlayout);
			llMain.addView(table, lParams);

			lParams.gravity = textgravity;
			
			TextView title = new TextView(this);
			TextView author = new TextView(this);
			
			title.setText("title" + i);
			author.setText("author" + i);
			
			title.setTextSize(25);
			author.setTextSize(20);
			
			table.addView(title, lParams);
			table.addView(author, lParams);

			lParams.gravity = gravity;
			Button btnNew = new Button(this);
			btnNew.setText("Choose this book!");
			btnNew.setTag("booktitle");
			table.addView(btnNew, lParams);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v){

		Log.i(TAG, "button clicked");

		Intent intent = new Intent(getBaseContext(), BookActivity.class);
		intent.putExtra("booktitle", (String) v.getTag());
		startActivity(intent);
		
//		
//		switch(v.getId()){
//		case R.id.button1:
//			Intent intent1 = new Intent(getBaseContext(), BookActivity.class);
//			//intent1.putExtra("title", "title");
//			startActivity(intent1);
//			break;
//		case R.id.button2:
//			Intent intent2 = new Intent(getBaseContext(), BookActivity.class);
//			startActivity(intent2);
//			break;
//		case R.id.button3:
//			Intent intent3 = new Intent(getBaseContext(), BookActivity.class);
//			startActivity(intent3);
//			break;
//		}


	}
}
