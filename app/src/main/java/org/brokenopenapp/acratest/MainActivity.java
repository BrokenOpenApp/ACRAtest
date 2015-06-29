package org.brokenopenapp.acratest;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import org.acra.ACRA;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public void onClickWebView (View view) {
		startActivity(new Intent(this, WebViewActivity.class));
	}


	public void onClickCrash1 (View view) {
		crashRuntimeException("CRASH HA HA BUTTON 1");
	}

	public  void onClickCrash2 (View view) {
		crashRuntimeException("CRASH HA HA BUTTON 2");
	}

	public  void onClickCrash3 (View view) {
		crashRuntimeException("CRASH HA HA BUTTON 3");
	}

	public  void onClickCrash4 (View view) {
		String s = null;
		int i = s.length();
	}

	protected void crashRuntimeException(String msg) {
		ACRA.getErrorReporter().handleException(new RuntimeException(msg));
	}

	public void  onClickCrash5 (View view) {

		crashRuntimeException("CRASH HA HA BUTTON 5");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
