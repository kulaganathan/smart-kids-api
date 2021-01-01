package com.kalaiworld.smartkidsapi.service;

import com.kalaiworld.smartkidsapi.entity.Topic;
import com.kalaiworld.smartkidsapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics(String courseId) {
        List<Topic> topics = null;
        if (!courseId.isEmpty()) {
            topics = topicRepository.findByCourseId(courseId);
        }
        return topics;
    }

}
