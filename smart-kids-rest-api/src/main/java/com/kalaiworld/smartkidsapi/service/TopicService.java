package com.kalaiworld.smartkidsapi.service;

import com.kalaiworld.smartkidsapi.entity.Topic;
import com.kalaiworld.smartkidsapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public String saveTopic(Topic topic) {
        String refId = null;
        if (topic != null) {
            topic.setRefId(UUID.randomUUID().toString());
            Topic savedTopic = topicRepository.save(topic);
            refId = savedTopic.getRefId();
        }
        return refId;
    }

}
