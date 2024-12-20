package com.quizapp.service.serviceImpl;

import com.quizapp.Entity.Question;
import com.quizapp.Entity.QuizSession;
import com.quizapp.repository.QuestionRepository;
import com.quizapp.repository.QuizSessionRepository;
import com.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public ResponseEntity<QuizSession> startQuiz(Long userId) {
        QuizSession session = quizSessionRepository.findByUserId(userId)
                .orElseGet(() -> {
                    QuizSession newSession = new QuizSession();
                    newSession.setUserId(userId);
                    newSession.setCorrectAnswers(0);
                    newSession.setIncorrectAnswers(0);
                    newSession.setAnsweredQuestions(List.of());
                    return quizSessionRepository.save(newSession);
                });

        return ResponseEntity.ok(session);

    }

    @Override
    public ResponseEntity<?> getRandomQuestion(Long userId) {
        QuizSession session = quizSessionRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Quiz session not found for user ID: " + userId));

        List<Long> answeredQuestionIds = session.getAnsweredQuestions();
        List<Question> availableQuestions = questionRepository.findAllByIdNotIn(answeredQuestionIds);

        // If no available questions
        if (availableQuestions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No more questions left");
        }
        Question randomQuestion = availableQuestions.get(new Random().nextInt(availableQuestions.size()));

        return ResponseEntity.ok(randomQuestion);
    }

    @Override
    public ResponseEntity<String> submitAnswer(Long userId, Long questionId, String answer) {

        QuizSession quizSession = quizSessionRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Quiz session not found for user ID: " + userId));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found for ID: " + questionId));

        boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(answer);

        if (isCorrect) {
            quizSession.setCorrectAnswers(quizSession.getCorrectAnswers() + 1);  // Increment correct answers
        } else {
            quizSession.setIncorrectAnswers(quizSession.getIncorrectAnswers() + 1);  // Increment incorrect answers
        }
        quizSession.getAnsweredQuestions().add(questionId);

        quizSessionRepository.save(quizSession);

        String message = isCorrect ? "Correct Answer!" : "Incorrect Answer! The correct answer is: " + question.getCorrectAnswer();
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}

