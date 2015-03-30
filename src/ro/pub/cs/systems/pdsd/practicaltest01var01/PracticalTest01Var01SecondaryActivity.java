package ro.pub.cs.systems.pdsd.practicaltest01var01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01SecondaryActivity extends Activity {

	private Button ok;
	private Button cancel;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var01_secondary);
		text= (TextView) findViewById(R.id.text_view);
		String allBoxes=(String) this.getIntent().getExtras().get("allBoxes");
	//	Toast.makeText(PracticalTest01Var01SecondaryActivity.this, "String "+allBoxes, Toast.LENGTH_LONG).show();
		
		text.setText(allBoxes);
		ok=(Button)findViewById(R.id.ok_button);
		cancel=(Button)findViewById(R.id.cancel_button);
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK, new Intent());
		          finish();
		          
			}
		});

		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setResult(RESULT_CANCELED, new Intent());
		          finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var01_secondary, menu);
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
	
	
}
