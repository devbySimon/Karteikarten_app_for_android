package dev.by.simon.karteikarten.LearningCourse.Items;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;
import dev.by.simon.karteikarten.KarteiKarten.Karteikarte;
import dev.by.simon.karteikarten.KarteiKarten.KarteikartenManager;
import dev.by.simon.karteikarten.LearningCourse.LearningCourse;

public class SimpleListLearningCourse implements LearningCourse
{
    private String name;
    
    private MutableLiveData<ArrayList<Karteikarte>> karteikarten;
    
    public SimpleListLearningCourse(String name)
    {
        this.name = name;
        
        this.karteikarten = new MutableLiveData<>();
        this.karteikarten.setValue(new ArrayList<Karteikarte>());
    }
    
    public String GetName()
    {
        return name;
    }
    
    public void AddKarteikarte(Karteikarte karteikarte)
    {
        karteikarten.getValue().add(karteikarte);
        karteikarten.postValue(karteikarten.getValue());
    }
    
    @Override
    public IRecycler_Item GetRecyclerItem()
    {
        return new SimpleListLearningCourse_RecyclerItem(this);
    }
    
    @Override
    public MutableLiveData<ArrayList<Karteikarte>> GetKarteikarten()
    {
        return karteikarten;
    }
}
