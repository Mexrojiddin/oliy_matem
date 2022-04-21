package uz.mexboy.oliy_matem;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import uz.mexboy.oliy_matem.ui.about.AboutFragment;
import uz.mexboy.oliy_matem.ui.home.HomeFragment;
import uz.mexboy.oliy_matem.ui.mundarija.MundarijaFragment;

public class MainActivity extends AppCompatActivity {
    public static Toolbar toolbar;
    private NavigationView navigationView;
    public static int defaultPage;


    private DrawerLayout drawer;

    public static int navPage = R.id.nav_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.nav_host_fragment,
                        new HomeFragment())
                .commit();
        getSupportFragmentManager().popBackStackImmediate();

        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() != navPage) {

                switch (item.getItemId()) {
                    case R.id.nav_home: {
                        MainActivity.toolbar.setTitle("Bosh sahifa");
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.nav_host_fragment,
                                        new HomeFragment())
                                .commit();
                        getSupportFragmentManager().popBackStackImmediate();


                        drawer.closeDrawers();
                        break;
                    }

                    case R.id.nav_mundarija: {
                        MainActivity.toolbar.setTitle("Mundarija");
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.nav_host_fragment,
                                        new MundarijaFragment())
                                .commit();
                        getSupportFragmentManager().popBackStackImmediate();

                        drawer.closeDrawers();
                        break;
                    }

                    case R.id.nav_about: {
                        MainActivity.toolbar.setTitle("Dastur haqida");
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.nav_host_fragment,
                                        new AboutFragment())
                                .commit();
                        getSupportFragmentManager().popBackStackImmediate();

                        drawer.closeDrawers();
                        break;
                    }
                }

                navPage = item.getItemId();
            } else {
                drawer.closeDrawers();
            }

            return false;

        });
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//        searchView.setQueryHint("Qidirish..");
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//
//
//                return false;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//    }




    @Override
    public boolean onSupportNavigateUp() {
        drawer.openDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }


    }

    @Override
    public void onBackPressed() {
        if (navPage == R.id.nav_home) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.nav_host_fragment,
                            new HomeFragment())
                    .commit();
            getSupportFragmentManager().popBackStackImmediate();

            navPage = R.id.nav_home;
        }
    }

    @Override
    protected void onStop() {
        SharedPreferences.Editor editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit();
        editor.putInt("page", defaultPage);
        editor.apply();

        //stoppping appppp
        super.onStop();

    }

    @Override
    protected void onStart() {
        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE);
        defaultPage = prefs.getInt("page", 0);
        super.onStart();
    }

}