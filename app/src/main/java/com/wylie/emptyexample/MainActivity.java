package com.wylie.emptyexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.wylie.emptyexample.handCalculator.CardType;
import com.wylie.emptyexample.handCalculator.CardTypeAdapter;
import com.wylie.emptyexample.handCalculator.Hand;
import com.wylie.emptyexample.handCalculator.HandCalculator;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Hand hand;
    private CardTypeAdapter handAdapter;
    private TextView handValueView;
    public HandCalculator handCalculator;
    public ActivityModes mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handCalculator = new HandCalculator();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        handCalculator.onCreate(this);
        mode = ActivityModes.HAND_CALCULATOR;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.handCalculator) {
            mode = ActivityModes.HAND_CALCULATOR;
            handCalculator.show(this);
            return true;
        }
        if (id == R.id.civ_cards) {
            mode = ActivityModes.CIV_CARDS;
            handCalculator.hide(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void add(View view) {
        switch (mode) {
            case HAND_CALCULATOR:
                handCalculator.addCard(view);
                break;
        }
    }
}
