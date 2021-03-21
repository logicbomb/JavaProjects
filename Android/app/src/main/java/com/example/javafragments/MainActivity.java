package com.example.javafragments;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Started.");
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
//
//
//



        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
//
       mViewPager = (ViewPager) findViewById(R.id.container);
       mViewPager.setOffscreenPageLimit(5);
       mViewPager.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               return true;
           }
       });
//
      setupViewPager(mViewPager);

    setmViewPager(1);


    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment1_layout(), "Fragment1");
        adapter.addFragment(new fragment2_layout(), "Fragment2");

       adapter.addFragment(new fragment3_layout(), "Fragment3");
     adapter.addFragment(new myDialogFragment(), "Dialogue Fragment");

        viewPager.setAdapter(adapter);




    }
    public void setmViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }
}