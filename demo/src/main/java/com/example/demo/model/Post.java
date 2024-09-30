package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    // mappedBy : post - 연관 관계의 주인이 Comment 엔티티에 post(속성) 필드임을 나타낸다.
    // 객체 필드 기준으로 생각해야 한다.

    // CascadeType.ALL - 제약을 설정하게 되면 Post 엔티티에 대한 모든 상태 변경(저장, 삭제 등)
    // 관련된 Comment 엔티티에 전파 된다.
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

}
