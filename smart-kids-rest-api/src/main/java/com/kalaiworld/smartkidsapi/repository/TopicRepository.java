package com.kalaiworld.smartkidsapi.repository;

import com.kalaiworld.smartkidsapi.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByCourseId(String courseId);
}
