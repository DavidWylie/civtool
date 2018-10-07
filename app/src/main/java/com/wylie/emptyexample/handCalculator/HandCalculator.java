package com.wylie.emptyexample.handCalculator;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.wylie.emptyexample.MainActivity;
import com.wylie.emptyexample.R;

import java.util.Locale;

public class HandCalculator {
    private Hand hand;
    private CardTypeAdapter handAdapter;
    private TextView handValueView;
    private int i=0;
    public void onCreate(MainActivity activity) {
        hand = new Hand();

        handAdapter = new CardTypeAdapter(activity, 0, hand.getCards());
        GridView gridView = activity.findViewById(R.id.lvHand);
        gridView.setAdapter(handAdapter);

        handValueView = activity.findViewById(R.id.handValue);
        handValueView.setText("Total Hand Value: 0");
    }

    public void addCard(View view) {
        i++;
        hand.add(new CardType("Bronze"+ i));
        handAdapter.notifyDataSetChanged();
        handValueView.setText(String.format(Locale.getDefault(), "Total Hand Value: %d", hand.getValue()));
    }

    public void removeCard(CardType cardType) {

        hand.remove(cardType);
        handAdapter.notifyDataSetChanged();
        handValueView.setText(String.format(Locale.getDefault(), "Total Hand Value: %d", hand.getValue()));
    }

    public void hide(MainActivity activity){
        View view =  activity.findViewById(R.id.handCalculator);
        if (view != null){
         view.setVisibility(View.INVISIBLE);
        }
    }

    public void show(MainActivity activity){
        View view =  activity.findViewById(R.id.handCalculator);
        if (view != null){
            view.setVisibility(View.VISIBLE);
        }
    }
}
