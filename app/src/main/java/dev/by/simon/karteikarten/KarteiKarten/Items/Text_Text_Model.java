package dev.by.simon.karteikarten.KarteiKarten.Items;

import android.content.Context;

import androidx.fragment.app.Fragment;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;
import dev.by.simon.karteikarten.KarteiKarten.Karteikarte;

public class Text_Text_Model extends KarteikartenBase
{
    public final String question;
    public final String answer;
    
    public Text_Text_Model(String question, String answer)
    {
        super();
        
        this.question = question;
        this.answer = answer;
    }
    
    @Override
    public Fragment GetFragment(Context context)
    {
        return new Text_Text_ViewModel(this);
    }
    
    @Override
    public IRecycler_Item GetDescriptiveRecyclerItem(Context context)
    {
        return new Text_Text_RecyclerItem(this);
    }
}
