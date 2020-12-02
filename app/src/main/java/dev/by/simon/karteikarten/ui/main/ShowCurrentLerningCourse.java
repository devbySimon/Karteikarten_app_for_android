package dev.by.simon.karteikarten.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;
import bysimon.developer.easycomplexrecyclerview.ListenerManager;
import bysimon.developer.easycomplexrecyclerview.RecyclerAdapter;
import dev.by.simon.karteikarten.KarteiKarten.Karteikarte;
import dev.by.simon.karteikarten.LearningCourse.LearningCourse;
import dev.by.simon.karteikarten.LearningCourse.LearningCourseManager;
import dev.by.simon.karteikarten.R;

public class ShowCurrentLerningCourse extends Fragment
{
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    public static ShowCurrentLerningCourse newInstance(int index)
    {
        ShowCurrentLerningCourse fragment = new ShowCurrentLerningCourse();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_show_all_learning_courses, container, false);
        
        RecyclerView recyclerView = root.findViewById(R.id.RecyclerList);
        recyclerAdapter = new RecyclerAdapter(recyclerView, getContext(), ListenerManager.getInstance());
        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        
        LearningCourseManager.getInstance().SelectedLearningCourse.observe(getViewLifecycleOwner(), new Observer<LearningCourse>()
        {
            @Override
            public void onChanged(@Nullable LearningCourse selectedLearningCourse)
            {
                if(selectedLearningCourse != null)
                {
                    selectedLearningCourse.GetKarteikarten().observe(getViewLifecycleOwner(), new Observer<ArrayList<Karteikarte>>()
                    {
                        @Override
                        public void onChanged(ArrayList<Karteikarte> karteikarten)
                        {
                            if(karteikarten != null)
                            {
                                recyclerAdapter.remove();
                                
                                for(Karteikarte karteikarte : karteikarten)
                                {
                                    IRecycler_Item item = karteikarte.GetDescriptiveRecyclerItem(getContext());
                                    
                                    if(item != null)
                                    {
                                        recyclerAdapter.add(item);
                                    }
                                }
                                
                                recyclerAdapter.updateAllItems();
                            }
                        }
                    });
                }
            }
        });
        
        return root;
    }
}