package com.groundzero.giftexchange.features.trait.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groundzero.giftexchange.data.ResponseData;
import com.groundzero.giftexchange.features.trait.data.TraitQuestion;

import java.util.ArrayList;
import java.util.List;

public class TraitSurveyStartResponseData implements ResponseData {
  @JsonProperty("survey_questions")
  private List<TraitQuestion> surveyQuestions;

  public TraitSurveyStartResponseData() {
    createSurvey();
  }

  public List<TraitQuestion> getSurveyQuestions() {
    return surveyQuestions;
  }

  private void createSurvey() {
    List<String> answerOne = new ArrayList<>();
    answerOne.add("answer 1 on question 1");
    answerOne.add("answer 2 question 1");
    answerOne.add("answer 3 question 1");
    answerOne.add("answer 4 question 1");

    List<String> answerTwo = new ArrayList<>();
    answerTwo.add("answer 1 question 2");
    answerTwo.add("answer 2 question 2");
    answerTwo.add("answer 3 question 2");
    answerTwo.add("answer 4 question 2");

    List<String> answerThree = new ArrayList<>();
    answerThree.add("answer 1 question 3");
    answerThree.add("answer 2 question 3");
    answerThree.add("answer 3 question 3");
    answerThree.add("answer 4 question 3");

    List<String> answerFour = new ArrayList<>();
    answerFour.add("answer 1 question 4");
    answerFour.add("answer 2 question 4");
    answerFour.add("answer 3 question 4");
    answerFour.add("answer 4 question 4");

    surveyQuestions = new ArrayList<>();
    surveyQuestions.add(new TraitQuestion(0, "Question 1", "Can you answer 1 question?", answerOne));
//    surveyQuestions.add(new TraitQuestion(0, "Question 2", "Can you answer 2 question?", answerTwo));
//    surveyQuestions.add(new TraitQuestion(0, "Question 3", "Can you answer 3 question?", answerThree));
//    surveyQuestions.add(new TraitQuestion(0, "Question 4", "Can you answer 4 question?", answerFour));
  }
}
