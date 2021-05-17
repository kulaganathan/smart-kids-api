package com.kalaiworld.smartkidsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
