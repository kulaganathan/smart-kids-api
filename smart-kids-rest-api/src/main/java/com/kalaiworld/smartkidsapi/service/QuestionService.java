package com.kalaiworld.smartkidsapi.service;

import com.kalaiworld.smartkidsapi.entity.Topic;
import com.kalaiworld.smartkidsapi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Topic> getQuestions(String topicId) {
        List<Topic> topics = null;
        if (!topicId.isEmpty()) {
            topics = questionRepository.findByTopicId(topicId);
        }
        return topics;
    }

}
