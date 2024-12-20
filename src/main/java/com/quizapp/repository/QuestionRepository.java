package com.quizapp.repository;

import com.quizapp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT q FROM Question q WHERE q.id NOT IN :answeredQuestionIds")
    List<Question> findAllByIdNotIn(List<Long> answeredQuestionIds);

}
