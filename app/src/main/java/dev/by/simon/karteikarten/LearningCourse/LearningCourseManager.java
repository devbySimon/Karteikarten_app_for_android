package dev.by.simon.karteikarten.LearningCourse;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class LearningCourseManager
{
    private static LearningCourseManager learningCourseManager;
    
    private LearningCourseManager()
    {
        AllLearningCoursesLiveData = new MutableLiveData<>();
        AllLearningCoursesLiveData.setValue(new ArrayList<LearningCourse>());
        
        SelectedLearningCourse = new MutableLiveData<>();
        SelectedLearningCourse.setValue(null);
    }
    
    public static LearningCourseManager getInstance()
    {
        if(LearningCourseManager.learningCourseManager == null)
        {
            LearningCourseManager.learningCourseManager = new LearningCourseManager();
        }
        
        return LearningCourseManager.learningCourseManager;
    }
    
    public MutableLiveData<ArrayList<LearningCourse>> AllLearningCoursesLiveData;
    
    public MutableLiveData<LearningCourse> SelectedLearningCourse;
    
    public void CreateNewLearningCourse(LearningCourse learningCourse)
    {
        AllLearningCoursesLiveData.getValue().add(learningCourse);
        AllLearningCoursesLiveData.postValue(AllLearningCoursesLiveData.getValue());
    }
    
    public void SelectLearningCourse(LearningCourse learningCourse)
    {
        SelectedLearningCourse.postValue(learningCourse);
    }
}
