package com.ranjeet.animationsapp;

/**
 * Created by HP on 12/12/2017.
 */

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.animation.ObjectAnimator;
import android.os.Bundle;

public class MainActivity3 extends ActionBarActivity {

    LinearLayout mainLayout;
    TextView textTitle;
    Button buttonFlip;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mainLayout = (LinearLayout)findViewById(R.id.mainlayout);
        mainLayout.setOnClickListener(MyOnClickListener);
        textTitle = (TextView)findViewById(R.id.title);
        textTitle.setOnClickListener(MyOnClickListener);
        buttonFlip = (Button)findViewById(R.id.buttonflip);
        buttonFlip.setOnClickListener(MyOnClickListener);
        image = (ImageView)findViewById(R.id.image);
        image.setOnClickListener(MyOnClickListener);

    }

    OnClickListener MyOnClickListener = new OnClickListener(){

        @Override
        public void onClick(View v) {
            flipIt(v);
        }

    };

    private void flipIt(final View viewToFlip) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(viewToFlip, "rotationX", 0f, 360f);
        flip.setDuration(3000);
        flip.start();

    }

}
