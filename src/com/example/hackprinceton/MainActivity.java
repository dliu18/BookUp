package com.example.hackprinceton;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

import com.example.picgame.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addItemsOnSpinner2();
		addItemsOnSpinner3();
		addListenerOnButton();
		addListenerOnSpinnerItemSelection();
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

	private Spinner department_cbe, department_mat, department_orf;
	private Button btnSubmit;


	// add items into spinner dynamically
	public void addItemsOnSpinner2() {

		department_mat = (Spinner) findViewById(R.id.department_mat);
		List<String> list = new ArrayList<String>();
		list.add("MAT 201");
		list.add("MAT 203");
		list.add("MAT 215");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		department_mat.setAdapter(dataAdapter);
	}

	public void addItemsOnSpinner3() {

		department_orf = (Spinner) findViewById(R.id.department_orf);
		List<String> list2 = new ArrayList<String>();
		list2.add("ORF 245");
		list2.add("ORF 307");
		list2.add("ORF 309");
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list2);
		dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		department_orf.setAdapter(dataAdapter2);

	}

	public void addListenerOnSpinnerItemSelection() {
		department_cbe = (Spinner) findViewById(R.id.department_cbe);
		department_cbe.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}

	// get the selected dropdown list value
	public void addListenerOnButton() {

		department_cbe = (Spinner) findViewById(R.id.department_cbe);
		department_mat = (Spinner) findViewById(R.id.department_mat);
		department_orf = (Spinner) findViewById(R.id.department_orf);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);

		btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(MainActivity.this,
						"You selected : " + 
								"\nCBE : "+ String.valueOf(department_cbe.getSelectedItem()) + 
								"\nMAT : "+ String.valueOf(department_mat.getSelectedItem()) +
								"\nORF : "+ String.valueOf(department_orf.getSelectedItem()),
								Toast.LENGTH_SHORT).show();

				Intent intent = new Intent(getBaseContext(), CourseActivity.class);
				startActivity(intent);
			}

		});


	}
}