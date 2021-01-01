package com.kalaiworld.smartkidsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String refId;
    private String name;
    private String description;
    @JsonIgnore
    @Column(name = "subject_id")
    private String subjectId;
    @JsonIgnore
    @Column(name = "program_id")
    private String programId;

}
