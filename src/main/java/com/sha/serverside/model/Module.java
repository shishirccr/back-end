package com.sha.serverside.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="course")
public class Module implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Course course;
}
