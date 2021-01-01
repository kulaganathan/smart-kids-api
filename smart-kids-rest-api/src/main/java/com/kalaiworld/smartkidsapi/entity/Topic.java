package com.kalaiworld.smartkidsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String refId;
    private String name;
    private String description;
    @JsonIgnore
    @Column(name = "course_id")
    private String courseId;
    @JsonIgnore
    @Column(name = "template_id")
    private String templateId;

}
