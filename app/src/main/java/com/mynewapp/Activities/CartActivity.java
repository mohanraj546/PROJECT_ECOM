package com.mynewapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mynewapp.Fragments.CartFragment;
import com.mynewapp.R;

/**
 * Created by Recrosoft on 17-Mar-17.
 */

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        initViews();
    }

    private void initViews() {
        getSupportFragmentManager().beginTransaction().replace(R.id.wish_container,new CartFragment()).commit();
    }
}
