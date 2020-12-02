package dev.by.simon.karteikarten;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;

import dev.by.simon.karteikarten.KarteiKarten.Karteikarte;

public class Statics
{
    private static MutableLiveData<ArrayList<Karteikarte>> karteikartenListe = new MutableLiveData<>();
    private static MutableLiveData<Integer> currentLearningCardDataIndex = new MutableLiveData<>();
    public static LiveData<Karteikarte> CurrentLearningCard = Transformations.map(currentLearningCardDataIndex, new Function<Integer, Karteikarte>()
    {
        @Override
        public Karteikarte apply(Integer index)
        {
            return karteikartenListe.getValue().get(index);
        }
    });
    
    public static void AddLearningCard(Karteikarte newLearningCard)
    {
        karteikartenListe.getValue().add(newLearningCard);
        karteikartenListe.postValue(karteikartenListe.getValue());
    }
    
    public static void ClearAllLearningCards()
    {
        karteikartenListe.setValue(new ArrayList<Karteikarte>());
        currentLearningCardDataIndex.postValue(0);
    }
    
    public static boolean GoToNextLearningCard()
    {
        if(currentLearningCardDataIndex.getValue() + 1 < karteikartenListe.getValue().size())
        {
            currentLearningCardDataIndex.postValue(currentLearningCardDataIndex.getValue() + 1);
            
            return true;
        }
        else
        {
            return false;
        }
    }
}
