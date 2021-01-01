package com.kalaiworld.smartkidsapi.service;

import com.kalaiworld.smartkidsapi.entity.Question;
import com.kalaiworld.smartkidsapi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions(String topicId) {
        List<Question> questions = null;
        if (!topicId.isEmpty()) {
            questions = questionRepository.findByTopicId(topicId);
        }
        return questions;
    }

    public String saveQuestion(Question question) {
        String refId = null;
        if (question != null) {
            question.setRefId(UUID.randomUUID().toString());
            Question savedQuestion = questionRepository.save(question);
            refId = savedQuestion.getRefId();
        }
        return refId;
    }

}
