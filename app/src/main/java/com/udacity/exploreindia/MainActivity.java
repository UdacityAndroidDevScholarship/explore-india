package com.udacity.exploreindia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("tavish" , "setcontentview");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("tavish" , "set support");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        //TODO remove the below line
        drawer.openDrawer(GravityCompat.START);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id_item = item.getItemId();
        switch(id_item){
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id_item = item.getItemId();
        switch(id_item){
            case R.id.nav_your_places :
                Toast.makeText(this, "Nav item clicked !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_your_timeline :
                Toast.makeText(this, "Nav item clicked !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_your_contributions :
                Toast.makeText(this, "Nav item clicked !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_offline_areas :
                Toast.makeText(this, "Nav item clicked !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_food :
                Toast.makeText(this, "Nav item clicked !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_interesting_places :
                Toast.makeText(this, "Nav item clicked !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_culture :
                Toast.makeText(this, "Nav item clicked !!", Toast.LENGTH_SHORT).show();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
