package com.example.chegg30.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.chegg30.Entity.Question;
import com.example.chegg30.Entity.User;
import com.example.chegg30.Model.Model;
import com.example.chegg30.Model.QuestionInteractor;

import java.util.ArrayList;

public class QuestionViewModel extends AndroidViewModel {
    private QuestionInteractor questionInteractor;
    private ArrayList<Question> questions;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        questionInteractor = Model.getInstanceOfModel().getQuestionInteractor();
        questions = questionInteractor.getAllQuestions();
    }

    public ArrayList<Question> getAllQuestions(){return questions;}

    public void addQuestion(String question, User user) {
        questionInteractor.addQuestion(new Question(question, user));
        questions = questionInteractor.getAllQuestions();
    }


}
