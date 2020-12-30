package com.kalaiworld.smartkidsapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String refId;
    private String name;
    private String description;

}
