package org.globalgamejam.strat;

import java.io.IOException;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ClientActivity extends Activity {

	private TextView vtIpDest;
	private EditText etIpDest, etPortDest;
	private Button bConnect;

	protected Socket sock;

	public void onCreate(Bundle savedInstanceState) {
		// Create the interface
		super.onCreate(savedInstanceState);
		setContentView(R.layout.client_layout);
		Log.d("Strat", "Client : client opened");

		// Retrieving of the UI handlers
		vtIpDest = (TextView) findViewById(R.id.tvIpDest);
		etIpDest = (EditText) findViewById(R.id.etIpDest);
		etPortDest = (EditText) findViewById(R.id.etPortDest);
		bConnect = (Button) findViewById(R.id.bConnect);

		// Connect the interface listeners
		bConnect.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// vtIpDest.setText("" +
				// Integer.parseInt(etPortDest.getText().toString()));
				// TODO Auto-generated method stub
				try {
					sock = new Socket("192.168.1.77", 50000);
					// sock = new Socket(etIpDest.getText().toString(),
					// Integer.parseInt(etPortDest.getText().toString()));
				} catch (IOException e) {
					Log.d("Strat", "Client : connection error "	+ e.getLocalizedMessage());
				}
			}
		});

	}
}