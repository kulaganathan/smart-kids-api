package com.kalaiworld.smartkidsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "images")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String refId;
    //    @Column(name = "question_id")
//    private String questionId;
    @Column(name = "image_num")
    private Integer imageNum;
    private String url;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "ref_id")
//    @ToString.Exclude
    private Question question;
}
