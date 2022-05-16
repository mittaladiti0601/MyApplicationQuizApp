package com.example.myapplicationquizapp;

public class QuestionLibrary {

    private String mQuestions [] = {
            "Am I taking anything for granted?",
            "Am I employing a healthy perspective?",
            "Am I living true to myself?",
            "Am I waking up in the morning ready to take on the day?",
            "Am I thinking negative thoughts before I fall asleep?",
            "Am I putting enough effort into my relationships?",
            "Am I taking care of myself physically?",
            "Am I letting matters that are out of my control stress me out?",
            "Am I achieving the goals that I’ve set for myself?"

    };


    private String mChoices [][] = {
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"}
    };



    private String mCorrectAnswers[] = {"Yes", "Yes", "Yes", "Yes", "No", "Yes", "Yes", "No", "Yes"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }


}