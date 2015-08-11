package com.example.pruebabarcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	 private View.OnClickListener click1=new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
	            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
	            startActivityForResult(intent, 0);
	        }
	    };

	    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	        if (requestCode == 0) {
	            if (resultCode == RESULT_OK) {
	                String contents = intent.getStringExtra("SCAN_RESULT");
	                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
	                // Handle successful scan
	            } else if (resultCode == RESULT_CANCELED) {
	                // Handle cancel
	            }
	        }
	    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button boton =(Button)findViewById(R.id.boton1);
        boton.setOnClickListener(click1);
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
}
