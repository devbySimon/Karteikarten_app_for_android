package dev.by.simon.karteikarten.ui.SingleKarte;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import dev.by.simon.karteikarten.KarteiKarten.Karteikarte;
import dev.by.simon.karteikarten.R;
import dev.by.simon.karteikarten.Statics;

public class SingleKarte extends AppCompatActivity
{
    boolean replace = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_karte);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        System.out.println("Moin");
        
        Statics.CurrentLearningCard.observe(this, new Observer<Karteikarte>()
        {
            @Override
            public void onChanged(@Nullable Karteikarte s)
            {
                if(Statics.CurrentLearningCard.getValue() != null)
                {
                    System.out.println("Fragment found");
                    
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    if(replace)
                    {
                        ft.replace(R.id.fragment_container, Statics.CurrentLearningCard.getValue().GetFragment(getApplicationContext())).disallowAddToBackStack();
                    }
                    else
                    {
                        ft.add(R.id.fragment_container, Statics.CurrentLearningCard.getValue().GetFragment(getApplicationContext())).disallowAddToBackStack();
                    }
                    ft.commit();
    
                    replace = true;
                }
                else
                {
                    System.out.println("No Fragment found");
                    
                    finish();
                }
            }
        });
    }
}