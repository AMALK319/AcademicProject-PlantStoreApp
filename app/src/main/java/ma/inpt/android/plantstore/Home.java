package ma.inpt.android.plantstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    static final int home = R.id.home;
    static final int favourites = R.id.favourites;
    static final int profile = R.id.profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.chtl_toolbar);
        setSupportActionBar(toolbar);

        HorizontalScrollView scrollable_contents = (HorizontalScrollView)  findViewById(R.id.scrollableContents);
        getLayoutInflater().inflate(R.layout.home_contents, scrollable_contents);

        HorizontalScrollView scrollable_contents_recom = (HorizontalScrollView)  findViewById(R.id.scrollableContentsRecom);
        getLayoutInflater().inflate(R.layout.home_contents, scrollable_contents_recom);

        HorizontalScrollView scrollable_contents_more = (HorizontalScrollView)  findViewById(R.id.scrollableContentsMore);
        getLayoutInflater().inflate(R.layout.home_contents, scrollable_contents_more);
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case home:
                        return true;
                    case favourites:
                        startActivity(new Intent(getApplicationContext(),Favourites.class));
                        overridePendingTransition(0,0);
                        return true;
                    case profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }
}