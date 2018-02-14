package com.ranjeet.animationsapp;

/**
 * Created by HP on 12/12/2017.
 */

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {
    private boolean isShowingBackLayout = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new FrontLayoutFragment4())
                    .commit();
        } else {
            isShowingBackLayout = (getFragmentManager().getBackStackEntryCount() > 0);
        }

        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                isShowingBackLayout = (getFragmentManager().getBackStackEntryCount() > 0);
            }
        });

        View btnFlip = findViewById(R.id.btn_flip);
      btnFlip.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (isShowingBackLayout) {
            getFragmentManager().popBackStack();
            return;
        }
        isShowingBackLayout = true;

        getFragmentManager().beginTransaction()
                // Replace the default fragment animations with animator resources representing
                // rotations when switching to the back of the card, as well as animator
                // resources representing rotations when flipping back to the front (e.g. when
                // the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a fragment
                // representing the next page (indicated by the just-incremented currentPage
                // variable).
                .replace(R.id.container, new BackLayoutFragment4())

                // Add this transaction to the back stack, allowing users to press Back
                // to get to the front of the card.
                .addToBackStack(null)
                .commit();
    }
}