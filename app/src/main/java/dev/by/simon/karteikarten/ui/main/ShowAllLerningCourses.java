package dev.by.simon.karteikarten.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;
import bysimon.developer.easycomplexrecyclerview.ListenerManager;
import bysimon.developer.easycomplexrecyclerview.RecyclerAdapter;
import dev.by.simon.karteikarten.LearningCourse.LearningCourse;
import dev.by.simon.karteikarten.LearningCourse.LearningCourseManager;
import dev.by.simon.karteikarten.R;

public class ShowAllLerningCourses extends Fragment
{
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    public static ShowAllLerningCourses newInstance(int index)
    {
        ShowAllLerningCourses fragment = new ShowAllLerningCourses();
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
        
        LearningCourseManager.getInstance().AllLearningCoursesLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<LearningCourse>>()
        {
            @Override
            public void onChanged(@Nullable ArrayList<LearningCourse> learningCourseArrayList)
            {
                if(learningCourseArrayList != null)
                {
                    recyclerAdapter.remove();
        
                    for(LearningCourse learningCourse : learningCourseArrayList)
                    {
                        IRecycler_Item item = learningCourse.GetRecyclerItem();
                        
                        if(item != null)
                        {
                            recyclerAdapter.add(item);
                        }
                    }
        
                    recyclerAdapter.updateAllItems();
                }
            }
        });
        return root;
    }
}