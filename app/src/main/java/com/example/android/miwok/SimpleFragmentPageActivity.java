package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by gurjas on 04-06-2017.
 */

public class SimpleFragmentPageActivity extends FragmentPagerAdapter {

    private Context mContext;

    private String tabTitles[] = new String[] {"Numbers","Colors","Family","Phrases"};

    public SimpleFragmentPageActivity(Context context,FragmentManager fragmentManager)
    {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new NumbersActivity();
        else if (position == 1)
            return new ColorsActivity();
        else if (position == 2)
            return new FamilyActivity();
        else
            return new PhrasesActivity();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.category_numbers);
        }
        else if (position == 1){
            return mContext.getString(R.string.category_colors);
        }
        else if (position == 2){
            return mContext.getString(R.string.category_family);
        }
        else
            return mContext.getString(R.string.category_phrases);
    }
}
