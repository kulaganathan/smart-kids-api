package com.kalaiworld.smartkidsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "questions")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Column(name = "ref_id")
    private String refId;
    @Column(name = "topic_id")
    @NonNull
    private String topicId;
    @Column(name = "line_1")
    @NonNull
    private String line1;
    @Column(name = "line_2")
    private String line2;
    @Column(name = "line_3")
    private String line3;
    @Column(name = "line_4")
    private String line4;
    @Column(name = "option_1")
    private String option1;
    @Column(name = "option_2")
    private String option2;
    @Column(name = "option_3")
    private String option3;
    @Column(name = "option_4")
    private String option4;
    @NonNull
    private String answer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @LazyCollection(LazyCollectionOption.TRUE)
    @Fetch(FetchMode.SELECT)
    private List<Image> images;

    public Question() {
    }

}
