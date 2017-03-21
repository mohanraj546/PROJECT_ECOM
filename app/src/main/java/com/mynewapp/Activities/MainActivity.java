package com.mynewapp.Activities;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mynewapp.Fragments.ContactUsFragment;
import com.mynewapp.Fragments.HomeFragment;
import com.mynewapp.Fragments.ProfileFragment;
import com.mynewapp.Fragments.WishListFragment;
import com.mynewapp.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
        mBottomBar.setDefaultTabPosition(0);

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                Fragment fragment = null;

                switch (tabId)
                {
                    case R.id.tab_home:
                        fragment = new HomeFragment();
                        addFragment(fragment);
                        break;
                    case R.id.tab_wishlist:
                        fragment = new WishListFragment();
                        addFragment(fragment);
                        break;
                    case R.id.tab_profile:
                        fragment = new ProfileFragment();
                        addFragment(fragment);
                        break;
                    case R.id.tab_contact:
                        fragment = new ContactUsFragment();
                        addFragment(fragment);
                        break;

                }
            }
        });

    }

    private void addFragment(Fragment fragment) {
        if(fragment != null)
           getSupportFragmentManager().beginTransaction().replace(R.id.frame_frag,fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_wishList:
                Toast.makeText(MainActivity.this, "wish selected", Toast.LENGTH_LONG).show();
                Intent wishActivity = new Intent(MainActivity.this,WishListActivity.class);
                startActivity(wishActivity);
                return true;

            case R.id.menu_cart:
                Toast.makeText(MainActivity.this, "cart selected", Toast.LENGTH_LONG).show();
                Intent cartActivity = new Intent(MainActivity.this,CartActivity.class);
                startActivity(cartActivity);
                return true;

            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }

}
