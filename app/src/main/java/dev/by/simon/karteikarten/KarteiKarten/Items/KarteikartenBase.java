package dev.by.simon.karteikarten.KarteiKarten.Items;

import android.content.Context;

import androidx.fragment.app.Fragment;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;
import dev.by.simon.karteikarten.KarteiKarten.Karteikarte;
import dev.by.simon.karteikarten.Util.Util;

public class KarteikartenBase implements Karteikarte
{
    private final String id;
    
    public KarteikartenBase()
    {
        id = Util.GenerateNewId();
    }
    
    @Override
    public String GetId()
    {
        return id;
    }
    
    @Override
    public Fragment GetFragment(Context context)
    {
        return null;
    }
    
    @Override
    public IRecycler_Item GetDescriptiveRecyclerItem(Context context)
    {
        return null;
    }
}
