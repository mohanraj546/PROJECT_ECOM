package com.mynewapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.mynewapp.Fragments.WishListFragment;
import com.mynewapp.R;

/**
 * Created by Recrosoft on 17-Mar-17.
 */

public class WishListActivity extends AppCompatActivity {

    private FrameLayout mFrame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        initViews();
    }

    private void initViews() {
        mFrame = (FrameLayout) findViewById(R.id.wish_container);

        getSupportFragmentManager().beginTransaction().replace(R.id.wish_container,new WishListFragment()).commit();
    }
}
