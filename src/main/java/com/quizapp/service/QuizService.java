package com.quizapp.service;

import com.quizapp.Entity.Question;
import com.quizapp.Entity.QuizSession;
import org.springframework.http.ResponseEntity;

public interface QuizService {


    ResponseEntity<QuizSession> startQuiz(Long userId);


    ResponseEntity<?> getRandomQuestion(Long userId);

    ResponseEntity<String> submitAnswer(Long userId, Long questionId, String answer);
}
