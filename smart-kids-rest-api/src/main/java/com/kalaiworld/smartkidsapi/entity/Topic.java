package com.kalaiworld.smartkidsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "topics")
public class Topic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String refId;
    private String name;
    private String description;
    @Column(name = "course_id")
    private String courseId;
    @Column(name = "template_id")
    private String templateId;

    Topic() {
    }

}
