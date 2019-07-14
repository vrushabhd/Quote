package com.demo.vrushabh.quote;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    private AdView mAdView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    public NavigationView navigationView;

    Button b1;
    private String Quotes[] = {"Don't cry because it's over, smile because it happened" + "\n\n\t Dr. Seuss",
            "Be yourself; everyone else is already taken" + "\n\n\tOscar Wilde", "You've gotta dance like there's nobody watching," +
            "Love like you'll never be hurt," +
            "Sing like there's nobody listening," +
            "And live like it's heaven on earth" + "\n\n\tWilliam W. Purkey",
            " Live as if you were to die tomorrow. Learn as if you were to live forever" + "\n\n\tMahatma Gandhi",
            " However difficult life may seem, there is always something you can do and succeed at." + "\n\n\tStephen Hawking",
            "Life is like riding a bicycle. To keep your balance, you must keep moving." + "\n\n\t Albert Einstein",
            " All life is an experiment. The more experiments you make the better." + "\n\n\tRalph Waldo Emerson",
            "Only I can change my life. No one can do it for me" + "\n\n\tCarol Burnett",
            " Optimism is the faith that leads to achievement. Nothing can be done without hope and confidence." + "\n\n\t Helen Keller",
            "It Always seems Impossible until its done" + "\n\n\tNelson Mandela",
            "Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time." + "\n\n\tThomas A. Edison",
            "Best way to predict the future is to create it" + "\n\n\tThomas Alva Edison",
            "Failure is a simple opportunity to begin again,this time more intelligently" + "\n\n\tHenry Ford"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout =(DrawerLayout)findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.nav);
       mToggle =new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.rateus) {
                    open();
                }
                if (id == R.id.Quote) {
                    Toast.makeText(getApplicationContext(), "Hi welcome to the Quote App", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        MobileAds.initialize(this, "ca-app-pub-6250812386412009~3323517203");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId("ca-app-pub-6250812386412009/7106973253");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        t1 = (TextView) findViewById(R.id.text);
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int num = random.nextInt(Quotes.length);
                t1.setText(Quotes[num]);
                t1.setTextIsSelectable(true);
                b1.setText("Click here for more quotes");
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
    public void open(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.vrushabh.quote"));
        startActivity(browserIntent);
    }

}



