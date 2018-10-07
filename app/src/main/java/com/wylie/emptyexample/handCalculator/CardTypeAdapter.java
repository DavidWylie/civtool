package com.wylie.emptyexample.handCalculator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wylie.emptyexample.MainActivity;
import com.wylie.emptyexample.R;

import java.util.List;
import java.util.Locale;

public class CardTypeAdapter extends ArrayAdapter<CardType> {
    private List<CardType> cards;

    public CardTypeAdapter(Context context, int resource, List<CardType> objects) {
        super(context, resource, objects);
        cards = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final CardType cardType = cards.get(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_card, parent, false);
        }
        if (cardType != null) {
            TextView listCardItem = convertView.findViewById(R.id.list_card_item);
            listCardItem.setText(String.format(Locale.getDefault(),"Count = %d \n %s \n Value = %d",cardType.getCount(), cardType.getName(), cardType.getValue()));
            Drawable img = getContext().getResources().getDrawable(R.drawable.grain,getContext().getTheme());
            img.setBounds( 0, 0, img.getIntrinsicWidth()/2, img.getIntrinsicHeight()/2 );
            listCardItem.setCompoundDrawablesRelative( null, img,null,null);

            listCardItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = getContext();
                    if(context instanceof MainActivity){
                        ((MainActivity)context).handCalculator.removeCard(cardType);
                    }
                }
            });
        }

        return convertView;
    }
}
