package com.kalaiworld.smartkidsapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "programs")
public class Program {

    @Id
    @Column(name = "program_id")
    private String programId;
    private String name;
    private String description;

}
