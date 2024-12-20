package com.quizapp.Entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class QuizSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int correctAnswers;

    private int incorrectAnswers;

    @ElementCollection
    private List<Long> answeredQuestions;

    public QuizSession() {
    }

    public QuizSession(Long id, Long userId, int correctAnswers, int incorrectAnswers, List<Long> answeredQuestions) {
        this.id = id;
        this.userId = userId;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
        this.answeredQuestions = answeredQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public List<Long> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<Long> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }
}
