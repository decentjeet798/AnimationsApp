package com.ranjeet.animationsapp;

/**
 * Created by HP on 12/12/2017.
 */

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends Activity {
    ImageView imgView;
    AnimatorSet set;
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         imgView=(ImageView)findViewById(R.id.imageview);


        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.flip);
                set.setTarget(imgView);
                set.start();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onStart(){
        super.onStart();
        ImageView imgView=(ImageView)findViewById(R.id.imageview);

        set = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.flip);
        set.setTarget(imgView);
        set.start();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ImageView imgView=(ImageView)findViewById(R.id.imageview);

        set = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.flip);
        set.setTarget(imgView);
        set.start();
    }
}