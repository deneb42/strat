package org.globalgamejam.strat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ClientActivity extends Activity {
    /** Called when the activity is first created. */
    
    private TextView vtIpDest;
	private EditText etIpDest, etPortDest;
    private Button bConnect;
    
    protected Socket sock;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_layout);
        
        // recuperation of the UI handlers
        vtIpDest = (TextView)findViewById(R.id.tvIpDest);
        etIpDest = (EditText)findViewById(R.id.etIpDest);
        etPortDest = (EditText)findViewById(R.id.etPortDest);
        bConnect = (Button)findViewById(R.id.bConnect);
        
       bConnect.setOnClickListener(new OnClickListener() {
		
		public void onClick(View arg0) {
			//vtIpDest.setText("" + Integer.parseInt(etPortDest.getText().toString()));
			// TODO Auto-generated method stub
			try {
				sock = new Socket("192.168.1.77", 50000);
				//sock = new Socket(etIpDest.getText().toString(), Integer.parseInt(etPortDest.getText().toString()));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.out.println("unknown host");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO exception");
				e.printStackTrace();
			}
			launchUI();
			finish();
		}
	});
        
        
    }
    
    private void launchUI() {
    	Intent intent = new Intent(this, GameUIActivity.class);
		startActivity(intent);
    }
}