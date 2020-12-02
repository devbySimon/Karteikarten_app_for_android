package dev.by.simon.karteikarten.ui.main;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import dev.by.simon.karteikarten.KarteiKarten.Items.Text_Text_Model;
import dev.by.simon.karteikarten.LearningCourse.Items.SimpleListLearningCourse;
import dev.by.simon.karteikarten.LearningCourse.LearningCourseManager;
import dev.by.simon.karteikarten.R;
import dev.by.simon.karteikarten.Statics;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        StatePageAdapter statePageAdapter = new StatePageAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(statePageAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    
        SimpleListLearningCourse learningCourse = new SimpleListLearningCourse("Test 1");
        learningCourse.AddKarteikarte(new Text_Text_Model("Hauptstadt von Niedersachsen","Hannover"));
        learningCourse.AddKarteikarte(new Text_Text_Model("Hauptstadt von Berlin","Berlin"));
        LearningCourseManager.getInstance().CreateNewLearningCourse(learningCourse);
        
        
        Statics.ClearAllLearningCards();
        
        //Intent intent = new Intent(MainActivity.this, SingleKarte.class);
        //startActivity(intent);
    }
}