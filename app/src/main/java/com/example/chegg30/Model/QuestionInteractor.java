package com.example.chegg30.Model;

import com.example.chegg30.Entity.Question;

import java.util.ArrayList;

public class QuestionInteractor extends Interactor {

    public QuestionInteractor(Database database) {
        super(database);
    }

    public ArrayList<Question> getAllQuestions() {return getMyDatabase().getAllQuestions();}

    public void addQuestion(Question question) {getMyDatabase().addQuestion(question);}
}
