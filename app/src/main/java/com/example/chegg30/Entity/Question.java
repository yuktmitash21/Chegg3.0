package com.example.chegg30.Entity;

import android.util.Log;

public class Question {
    private String questionText;
    private String answerText;
    private static int questionNumber;
    private User asker;
    private static final String TAG = "Question.java";

    public Question(String questionText, User asker) {
        this.questionText = questionText;
        this.asker = asker;

        questionNumber++;
        Log.d(TAG, "Question number: " + questionNumber);
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return getQuestionText().equals(question.getQuestionText());
    }

    public User getAsker() {
        return asker;
    }

    public void setAsker(User asker) {
        this.asker = asker;
    }

    @Override
    public int hashCode() {
        int a = 15;
        a = 32 * a + questionText.hashCode();
        a = 32 * a + answerText.hashCode();
        a = 32 * a + asker.hashCode();
        return a;
    }

    public int getId() {
        return questionNumber;
    }
}
