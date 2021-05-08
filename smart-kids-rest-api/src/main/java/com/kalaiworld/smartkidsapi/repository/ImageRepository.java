package com.kalaiworld.smartkidsapi.repository;

import com.kalaiworld.smartkidsapi.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByQuestionId(String questionId);
}
