package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by gurjas on 30-05-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * public constructor
     * we implement this constructor with 2 variables i.e. Context and words.
     * Context means for the activity
     * words contains the objects received from NumbersActivity
     */
    private int mBackgroundColor;
    private int mBackgroundAudio;

    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        super(context, 0, words);
        mBackgroundColor = colorResourceID;
    }

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID, int audioResourceID) {
        super(context, 0, words);
        mBackgroundColor = colorResourceID;
        mBackgroundAudio = audioResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //initialize view;
        View listItemView = convertView;

        /**
         * Check if view is empty or not.
         * If empty inflate view with the layout only.
         * Layout was defined in R.layout.list_item.
         */
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //word object item for current position
        Word currentWord = getItem(position);

        //get default translation for current item
        TextView defaultTransition = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTransition.setText(currentWord.getDefaultTranslation());

        //get miwok translation for current item
        TextView miwokTransition = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTransition.setText(currentWord.getMiwokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageIcon);
        if(currentWord.getImageResourceID()!= 0){
            //get Image
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentWord.getImageResourceID());
        }
        else
        {
            imageView.setVisibility(View.GONE);
        }

        /**
         * Update the listview's background color for each list.
         */
        if (mBackgroundColor!=0)
        {
            listItemView.setBackgroundResource(mBackgroundColor);
        }

        /**
         * return view. This statement is necessary because, you after initializing the value
         * and implementing all the values, you need to return the view.
         */
        return listItemView;
    }
}
