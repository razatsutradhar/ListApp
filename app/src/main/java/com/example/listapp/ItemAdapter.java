package com.example.listapp;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {                                    //this adapter is an extension of BaseAdapter meaning we need to populate abstract methods
    LayoutInflater mInflator;                                                                    //this is an inflator that populates the activity for each item in the list
    String[] items;                                                                                 //arrays with information on each item in the list
    String[] descriptions;
    String[] prices;

    public ItemAdapter(Context c, String[] i, String[] d, String[] p){
        items = i;
        descriptions = d;
        prices = p;
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);     //we make a layoutInflator with the context of this layout and layout inflator service
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {                                    //we need to populate the view of each item of the list
        View v = mInflator.inflate(R.layout.my_listview_layout, null);                         //we get the default textViews set in first
        TextView nameTextView = v.findViewById(R.id.nameTextView);                                  //then we get the textViews
        TextView descriptionTextView = v.findViewById(R.id.descriptionTextView);                    //^
        TextView priceTextView = v.findViewById(R.id.priceTextView);                                //^^

        String name = items[i];                                                                     //we get the String for the item index in the setup matracies
        String desc = descriptions[i];
        String pric = prices[i];

        nameTextView.setText(Html.fromHtml(name));                                                  //we set the text of each textView to the string from the arrays
        descriptionTextView.setText(Html.fromHtml(desc));
        priceTextView.setText(Html.fromHtml(pric));

        return v;                                                                                   //we return the view to display it
    }
}
