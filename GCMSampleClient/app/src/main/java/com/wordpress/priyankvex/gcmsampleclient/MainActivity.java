package com.wordpress.priyankvex.gcmsampleclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wordpress.priyankvex.gcmsampleclient.services.RegistrationAsyncTask;


public class MainActivity extends AppCompatActivity {

    // Widgets
    Button buttonRegister;
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding views
        findViewsById();

        buttonRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Start the service to get the token and send it to app server.
                new RegistrationAsyncTask(MainActivity.this).execute();
            }
        });
    }

    private void findViewsById(){
        buttonRegister = (Button) findViewById(R.id.button);
        textViewMessage = (TextView) findViewById(R.id.textView);
    }

    public void updateMessage(String message){
        textViewMessage.setText(message);
    }
}
