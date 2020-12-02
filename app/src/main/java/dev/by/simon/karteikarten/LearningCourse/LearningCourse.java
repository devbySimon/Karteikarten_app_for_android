package dev.by.simon.karteikarten.LearningCourse;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;
import dev.by.simon.karteikarten.KarteiKarten.Karteikarte;

public interface LearningCourse
{
    public IRecycler_Item GetRecyclerItem();
    
    public MutableLiveData<ArrayList<Karteikarte>> GetKarteikarten();
}
