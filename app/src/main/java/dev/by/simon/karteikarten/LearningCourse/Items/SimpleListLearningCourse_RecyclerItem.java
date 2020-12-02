package dev.by.simon.karteikarten.LearningCourse.Items;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import bysimon.developer.easycomplexrecyclerview.IRecycler_Item;
import bysimon.developer.easycomplexrecyclerview.RecyclerAdapter;
import dev.by.simon.karteikarten.LearningCourse.LearningCourse;
import dev.by.simon.karteikarten.LearningCourse.LearningCourseManager;
import dev.by.simon.karteikarten.R;

public class SimpleListLearningCourse_RecyclerItem extends IRecycler_Item
{
    private SimpleListLearningCourse learningCourse;
    
    public SimpleListLearningCourse_RecyclerItem(SimpleListLearningCourse learningCourse)
    {
        this.learningCourse = learningCourse;
        
        this.layoutId_2 = R.layout.recycleritem_learningcourse;
    }
    
    @Override
    public void onButtonHoldNormal(int buttonId, View button, Context context, RecyclerAdapter adapter)
    {
    
    }
    
    @Override
    public void onButtonClickNormal(int buttonId, View button, Context context, RecyclerAdapter adapter)
    {
        //Bei Click auf LearningCourseItem -> aktiven LearningCourse in Statics LiveData. Tab 1 lädt den neu und lädt alle Karteikarten in Liste
    }
    
    @Override
    public void renderNormal(View view, Context context, RecyclerAdapter adapter)
    {
        TextView title = view.findViewById(R.id.TextView_Title);
        title.setText(learningCourse.GetName());
        
        View layout = view.findViewById(R.id.constraintLayout);
        layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("Select Learning Course");
                LearningCourseManager.getInstance().SelectLearningCourse(learningCourse);
            }
        });
    }
}
