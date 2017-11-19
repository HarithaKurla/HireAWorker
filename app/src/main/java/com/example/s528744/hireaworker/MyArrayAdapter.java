package com.example.s528744.hireaworker;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by s528766 on 11/17/2017.
 */

public class MyArrayAdapter extends ArrayAdapter {

    public MyArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<RegistrationInfo> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        TextView nameTV = (TextView) v.findViewById(R.id.textView13);
        TextView contactTV = (TextView) v.findViewById(R.id.textView14);
        TextView costTV = (TextView) v.findViewById(R.id.textView16);



        RegistrationInfo o1 = (RegistrationInfo) getItem(position);


        nameTV.setText(o1.getFname().toString());
        contactTV.setText(o1.getPhonenumber().toString() + "");
        costTV.setText(Integer.toString(o1.getCost()));


        return v;
    }
}

