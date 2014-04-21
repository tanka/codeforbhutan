package com.tanka.fastdial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Welcome extends Activity {
	
	public static final long TIME_DELAY = 2 * 1000;
	

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /*// hide action bar
        ActionBar actionBar = getSupportActionBar();
		actionBar.hide();*/

        // set screen layout
        setContentView(R.layout.welcome);        
    }
    
	protected boolean _active = true;
	protected int _splashTime = 2000;
    
   @Override
    public void onResume() {
		super.onResume();
		


		// thread for displaying the SplashScreen
		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (_active && (waited < _splashTime)) {
						sleep(100);
						if (_active) {
							waited += 100;
						}
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					finish();

					startActivity(new Intent(Welcome.this,
							ContactList.class));
				}
			}
		};
		splashTread.start();
	
	
		
	};
}