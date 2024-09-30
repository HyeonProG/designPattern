package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 코드 --> db 위임
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
