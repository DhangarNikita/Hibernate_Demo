package com.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question1 {
    @Id
    @Column(name="question_id")
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "question1", cascade = CascadeType.ALL)
    private List<Answer1> answers;

    public Question1(){

    }

    public Question1(int question_id, String question,List<Answer1> answers) {
        this.questionId = question_id;
        this.question = question;
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer1> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer1> answers) {
        this.answers = answers;
    }
}
