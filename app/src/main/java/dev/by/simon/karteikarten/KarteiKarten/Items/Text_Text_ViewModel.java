package dev.by.simon.karteikarten.KarteiKarten.Items;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import dev.by.simon.karteikarten.R;
import dev.by.simon.karteikarten.Statics;

public class Text_Text_ViewModel extends Fragment
{
    private Text_Text_Model karteikarte;
    
    public Text_Text_ViewModel(Text_Text_Model karteikarte)
    {
        System.out.println("Constructor");
        
        this.karteikarte = karteikarte;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        System.out.println("onCreate");
        
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        System.out.println("Draw");
        
        View root = inflater.inflate(R.layout.text_text_fragment, container, false);
        
        TextView question = root.findViewById(R.id.textView_question);
        question.setText(this.karteikarte.question);
        final EditText answer = root.findViewById(R.id.editText_answer);
        answer.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
        
            }
    
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(answer.getText().toString().toLowerCase().equals(karteikarte.answer.toLowerCase()))
                {
                    if(Statics.GoToNextLearningCard())
                    {
                    
                    }
                    else
                    {
                        getActivity().finish();
                    }
                }
            }
    
            @Override
            public void afterTextChanged(Editable s)
            {
        
            }
        });
        
        return root;
    }
}