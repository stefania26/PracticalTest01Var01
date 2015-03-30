package ro.pub.cs.systems.pdsd.practicaltest01var01;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class PracticalTestVar01MainActivity extends Activity {
	 private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	CheckBox checkbox1,checkbox2,checkbox3;
	int numberOfEvents;
	EditText textNumber;
	private Button navigate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var01_main);
		
		checkbox1=(CheckBox)findViewById(R.id.checkBox1);
		checkbox2=(CheckBox)findViewById(R.id.checkBox2);
		checkbox3=(CheckBox)findViewById(R.id.checkBox3);
		textNumber=(EditText)findViewById(R.id.textnumber);
		
		if (savedInstanceState != null) {
			if (savedInstanceState.getBoolean("box1")) checkbox1.setChecked(true);
			if (savedInstanceState.getBoolean("box2")) checkbox2.setChecked(true);
			if (savedInstanceState.getBoolean("box3")) checkbox3.setChecked(true);
			textNumber.setText(savedInstanceState.getString("text"));
		}
		
		
		
		numberOfEvents=0;
		
		
		checkbox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (buttonView.isChecked())  {
					numberOfEvents++;
					textNumber.setText(Integer.toString(numberOfEvents));
				}
				else {
					numberOfEvents--;
					textNumber.setText(Integer.toString(numberOfEvents));
				}
				
			}
		});

		
		checkbox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					

					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						if (buttonView.isChecked())  {
							numberOfEvents++;
							textNumber.setText(Integer.toString(numberOfEvents));
						}
						else {
							numberOfEvents--;
							textNumber.setText(Integer.toString(numberOfEvents));
						}
						
					}
				});

		checkbox3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (buttonView.isChecked())  {
					numberOfEvents++;
					textNumber.setText(Integer.toString(numberOfEvents));
				}
				else {
					numberOfEvents--;
					textNumber.setText(Integer.toString(numberOfEvents));
				}
				
			}
		});
		
		
navigate=(Button)findViewById(R.id.navigateTo);
        
        navigate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String s="";
				if (checkbox1.isChecked())
					s=s+getResources().getString(R.string.phone);
				if (checkbox2.isChecked())
					s=s+","+getResources().getString(R.string.email);
				if (checkbox3.isChecked())
					s=s+","+getResources().getString(R.string.instantmess);
				Intent i=new Intent(PracticalTestVar01MainActivity.this, PracticalTest01Var01SecondaryActivity.class);
				i.putExtra("allBoxes",s );
				startActivityForResult(i, SECONDARY_ACTIVITY_REQUEST_CODE);
			}
		});

	}

	@Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
		checkbox1=(CheckBox)findViewById(R.id.checkBox1);
		checkbox2=(CheckBox)findViewById(R.id.checkBox2);
		checkbox3=(CheckBox)findViewById(R.id.checkBox3);
		
		textNumber=(EditText)findViewById(R.id.textnumber);
		
		savedInstanceState.putString("text", textNumber.getText().toString());

		if (checkbox1.isChecked())
			savedInstanceState.putBoolean("box1", true);
		else savedInstanceState.putBoolean("box1", false);
		
		
		if (checkbox2.isChecked())
			savedInstanceState.putBoolean("box2", true);
		else savedInstanceState.putBoolean("box2", false);
		
		if (checkbox3.isChecked())
			savedInstanceState.putBoolean("box3", true);
		else savedInstanceState.putBoolean("box3", false);
	  }
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test_var01_main, menu);
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
	
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
	  }
}
