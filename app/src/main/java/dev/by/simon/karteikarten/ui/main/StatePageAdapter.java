package dev.by.simon.karteikarten.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import dev.by.simon.karteikarten.R;

public class StatePageAdapter extends FragmentPagerAdapter
{
    @StringRes
    private final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Fragment[] allFragments = new Fragment[] {new ShowAllLerningCourses(), new ShowCurrentLerningCourse()};
    private final Context mContext;

    public StatePageAdapter(Context context, androidx.fragment.app.FragmentManager fm)
    {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        return allFragments[position];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount()
    {
        return allFragments.length;
    }
}