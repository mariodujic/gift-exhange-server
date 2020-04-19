package com.groundzero.giftexchange.features.trait.data;

import java.util.List;

public class TraitQuestion {
  private int id;
  private String title;
  private String question;
  private List<String> answers;

  public TraitQuestion(int id, String title, String question, List<String> answers) {
    this.id = id;
    this.title = title;
    this.question = question;
    this.answers = answers;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getQuestion() {
    return question;
  }

  public List<String> getAnswers() {
    return answers;
  }
}
