package com.example.mychat;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mychat.ui.main.WelcomeFr;

public class MainActivity extends AppCompatActivity {
    Button btnEnter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


     if (savedInstanceState == null) {
         getSupportFragmentManager().beginTransaction()
                 .replace(R.id.container, WelcomeFr.newInstance())
                 .commitNow();


        }

    }


}