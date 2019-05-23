package com.example.chegg30.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the interface to the domain/business classes from anywhere else in the application
 *
 *
 * This class provides all the interactors for the application.
 *
 * It is a Singleton so that it can be accessed from anywhere in the application
 */


public class Model {
    private Database myDatabase;

    private static Model instanceOfModel = new Model();

    private Map<String, Object> interactorMap;

    public static Model getInstanceOfModel() {
        return instanceOfModel;
    }

    private Model() {
        myDatabase = new Database();
        interactorMap = createMap();

    }

    public HashMap<String, Object> createMap() {
        HashMap<String, Object> interactors = new HashMap<>();
        interactors.put("user", new UserInteractor(myDatabase));
        interactors.put("question", new QuestionInteractor(myDatabase));
        return interactors;
    }

    public UserInteractor getUserInteractor() {
        return (UserInteractor) interactorMap.get("user");
    }

    public QuestionInteractor getQuestionInteractor() {
        return (QuestionInteractor) interactorMap.get("question");
    }



}
