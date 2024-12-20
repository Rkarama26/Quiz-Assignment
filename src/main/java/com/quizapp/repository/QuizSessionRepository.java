package com.quizapp.repository;

import com.quizapp.Entity.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {

    Optional<QuizSession> findByUserId(Long userId);
}
