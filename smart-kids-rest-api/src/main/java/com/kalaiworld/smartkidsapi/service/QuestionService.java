package com.kalaiworld.smartkidsapi.service;

import com.kalaiworld.smartkidsapi.entity.Image;
import com.kalaiworld.smartkidsapi.entity.Question;
import com.kalaiworld.smartkidsapi.repository.ImageRepository;
import com.kalaiworld.smartkidsapi.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ImageRepository imageRepository;

    public List<Question> getQuestions(String topicId) {
        List<Question> questions = null;
        if (!topicId.isEmpty()) {
            questions = questionRepository.findByTopicId(topicId);
        }
        return questions;
    }

    @Transactional
    public String saveQuestion(Question question) {
        String refId = null;
        if (question != null) {
            question.setRefId(UUID.randomUUID().toString());
//            for(Image image:question.getImages()){
//                image.setQuestion(question);
//            }
            List<Image> imgList;
            imgList = (List) question.getImages().stream().map((image -> {
                image.setRefId(UUID.randomUUID().toString());
                image.setQuestion(question);
                return image;
            })).collect(Collectors.toList());
            question.setImages(imgList);
            Question savedQuestion = questionRepository.saveAndFlush(question);
            refId = savedQuestion.getRefId();
            log.info("Question Ref Id is {}", refId);
        }
        return refId;
    }

}
