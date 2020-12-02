package dev.by.simon.karteikarten.KarteiKarten;

import android.content.Context;

import androidx.fragment.app.Fragment;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;

public interface Karteikarte
{
    public Fragment GetFragment(Context context);
    
    public IRecycler_Item GetDescriptiveRecyclerItem(Context context);
    
    public String GetId();
}
