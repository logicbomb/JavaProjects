package com.example.androidhelloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.activity_main);

        Button  btnSubmit;
        final TextView txtDisplay;
        final EditText txtInput;

        btnSubmit = (Button) findViewById(R.id.btninput);
        txtDisplay = (TextView)findViewById(R.id.textDisplay);
        txtInput = (EditText)findViewById(R.id.inputText);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDisplay.setText(txtInput.getText());
            }
        });
    }


        @Override
    protected void onStop() {

        super.onStop();
    }
}