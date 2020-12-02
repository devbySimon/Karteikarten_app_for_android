package dev.by.simon.karteikarten.KarteiKarten.Items;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;
import bysimon.developer.easycomplexrecyclerview.RecyclerAdapter;
import dev.by.simon.karteikarten.R;

public class Text_Text_RecyclerItem extends IRecycler_Item
{
    private Text_Text_Model karteikarte;
    
    public Text_Text_RecyclerItem(Text_Text_Model karteikarte)
    {
        this.karteikarte = karteikarte;
        
        this.layoutId_2 = R.layout.text_text_recycleritem;
    }
    
    @Override
    public void renderNormal(View view, Context context, RecyclerAdapter adapter)
    {
        TextView title = view.findViewById(R.id.TextView_Title);
        title.setText(karteikarte.question);
    }
}
