package com.kalaiworld.smartkidsapi.repository;

import com.kalaiworld.smartkidsapi.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTopicId(String topicId);
}
