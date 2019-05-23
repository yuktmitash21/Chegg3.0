package com.example.chegg30.Model;

import com.example.chegg30.Entity.Question;
import com.example.chegg30.Entity.User;

import java.util.ArrayList;

public class Database {

    private ArrayList<User> userArrayList;
    private ArrayList<Question> questionArrayList;

    public Database() {
        userArrayList = new ArrayList<>();
        questionArrayList = new ArrayList<>();
        setUpInitialData();
    }

    public void setUpInitialData() {
        User user1 = new User("MilkSteak", "password");
        User user2 = new User("DonkeyBrain", "password");
        User user3 = new User("AluminumMonster", "password");
        User user4 = new User("GoldenGod",  "password");
        User user5 = new User("CharDeeMacDennis", "password");
        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);
        userArrayList.add(user4);
        userArrayList.add(user5);
        questionArrayList.add(new Question("What is the mitochondria", user1));
        questionArrayList.add(new Question("Is pluto a planet", user2));
        questionArrayList.add(new Question("When was the Cuban Missile Crisis", user3));
        questionArrayList.add(new Question("Best President?", user4));
        questionArrayList.add(new Question("In what year did we put a man on the moon?", user5));
    }

    public ArrayList<User> getAllUsers() {
        return userArrayList;
    }

    public ArrayList<Question> getAllQuestions() {
        return questionArrayList;
    }

    /**
     * @param user is a User object
     * @return true if user is registered false otherwise
     */
    public boolean validUser(User user) {
        //TODO in class
        return false;
    }
    /**
     * only called when a user is found to be invalid
     * @return "invalid username" is username  or username and password is invalid
     * @return "invalid password" if password is invalid
     *
     */
    public String returnErrorMessage(User user) {
        //TODO in class
        return null;

    }

    /**
    * @param user is a User object
    * Register the user
    *
     */
    public void registerUser(User user) {
        //TODO in class

    }

    /**
    * @param question is a question object
    * add the question to the database
    *
     */
    public void addQuestion(Question question) {
       //TODO in class


    }


}
