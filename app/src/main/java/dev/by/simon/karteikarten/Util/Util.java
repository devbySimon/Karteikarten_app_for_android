package dev.by.simon.karteikarten.Util;

import android.content.SharedPreferences;

import bysimon.developer.easycomplexrecyclerview.ISimpleAction;

public class Util
{
    public static SharedPreferences SharedPreferences;
    
    public static ISimpleAction OnDataEditedByUserAction;
    
    public static String GenerateNewId()
    {
        long currentTime = System.currentTimeMillis();
        
        char[] charsLower = new char[] {'A','B','C','D','E'};
        char[] charsUpper = new char[] {'I','J','K','L','M'};
        
        String id = "";
        boolean lower = true;
        
        while (currentTime > 10)
        {
            int place = (int) (currentTime % 10);
            
            if(place % 2 == 1)
            {
                if(place < 5)
                {
                    lower = !lower;
                }
                
                if(lower)
                {
                    id += charsLower[place % 5];
                }
                else
                {
                    id += charsUpper[place % 5];
                }
            }
            else
            {
                id += place;
            }
            
            currentTime /= 10;
        }
        
        return id;
    }
}
