package com.example.admin.aplicationforcursaci;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HamburgerList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewFlipper v_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hamburger_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int images[] = {R.drawable.baner1,R.drawable.baner2,R.drawable.baner3,R.drawable.baner4,R.drawable.baner5};
        v_flipper=findViewById(R.id.v_flipper);

        for (int image : images)
        {
            flipperImages(image);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
         v_flipper.addView(imageView);
         v_flipper.setFlipInterval(2000);
         v_flipper.setAutoStart(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            Intent intent = new Intent(HamburgerList.this, ActivityHome.class);
            startActivity(intent);

        } else if (id == R.id.nav_shop){
            Intent intent = new Intent(HamburgerList.this, ActivityShop.class);
            startActivity(intent);

        } else if (id == R.id.nav_contact) {
            Intent intent = new Intent(HamburgerList.this, ActivityContacts.class);
            startActivity(intent);

        } else if (id == R.id.nav_addbani) {
            Intent intent = new Intent(HamburgerList.this, ActivityAddmoney.class);
            startActivity(intent);

        } else if (id == R.id.nav_help) {
            Intent intent = new Intent(this,HelpActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void onSocialButtonClick(View view) {
       int id = view.getId();

       if(id==R.id.imageButton){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
            startActivity(browserIntent);
       }else
           if(id==R.id.imageButton2){

               Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
               startActivity(browserIntent);
           }
           else {
               Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.org/"));
               startActivity(browserIntent);

           }

    }
}
