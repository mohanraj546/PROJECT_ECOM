package com.mynewapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mynewapp.Fragments.ContactUsFragment;
import com.mynewapp.Fragments.HomeFragment;
import com.mynewapp.Fragments.ProductsFragment;
import com.mynewapp.Fragments.ProfileFragment;
import com.mynewapp.Fragments.WishListFragment;
import com.mynewapp.R;

/**
 * Created by Recrosoft on 20-Mar-17.
 */

public class ProductssActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productsnew);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        // initializing navigation menu
        setUpNavigationView();

        getSupportActionBar().setTitle("Products");

        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out).replace(R.id.frame,new ProductsFragment()).commit();

    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment fragment = null;
                int position = -1;
                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {

                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        position = 0;
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_wishlist:
                        position = 1;
                        fragment = new WishListFragment();
                        break;
                    case R.id.nav_profile:
                        position = 2;
                        fragment = new ProfileFragment();
                        break;
                    case R.id.nav_contactus:
                        position = 3;
                        fragment = new ContactUsFragment();
                        break;
//                    default:
//                        navItemIndex = 0;
                }

                int size = navigationView.getMenu().size();
                for (int i = 0; i < size; i++) {
                    navigationView.getMenu().getItem(i).setChecked(false);
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }


                getSupportActionBar().setTitle(activityTitles[position]);

                Log.e("ProductsAct","Fragment"+fragment);
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out).replace(R.id.frame,fragment).commit();

                //Closing drawer on item click
                drawer.closeDrawers();

                // refresh toolbar menu
                invalidateOptionsMenu();
                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_wishList:
                Toast.makeText(this, "wish selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_cart:
                Toast.makeText(this, "cart selected", Toast.LENGTH_LONG).show();
                return true;

            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }


}
