package org.globalgamejam.strat;

import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.view.Window;


public class GameUIActivity extends Activity {
	/** Called when the activity is first created. */
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.gui_layout);
        
	}
}
