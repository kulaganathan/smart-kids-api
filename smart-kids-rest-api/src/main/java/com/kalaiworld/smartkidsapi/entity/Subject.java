package com.kalaiworld.smartkidsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String refId;
    private String name;
    private String description;

}
