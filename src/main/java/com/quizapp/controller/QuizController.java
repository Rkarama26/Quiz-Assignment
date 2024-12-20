package com.quizapp.controller;

import com.quizapp.Entity.Question;
import com.quizapp.Entity.QuizSession;
import com.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<QuizSession> startQuiz(@RequestParam Long userId) {
        return quizService.startQuiz(userId);
    }

     @GetMapping("/question")
    public  ResponseEntity<?> getRandomQuestion(@RequestParam Long userId) {
        return quizService.getRandomQuestion(userId);
    }

    @PostMapping("/answer")
    public ResponseEntity<String> submitAnswer(@RequestParam Long userId, @RequestParam Long questionId, @RequestParam String answer) {
        return quizService.submitAnswer(userId, questionId, answer);
    }
/*
    @GetMapping("/stats")
    public QuizSession getStats(@RequestParam Long userId) {
        return quizService.getStats(userId);
    }
     */




}
