package com.example.demo.domain.posts;

import com.example.demo.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 어노테이션 순서는 주요 어노테이션을 클래스에 가깝게 설정
// Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다. 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가
@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 명시, 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY 옵션 = auto_increment
    private Long id;

    /*
    Column은 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨
    사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나, 타입을 TEXT로 변경하고 싶을 때 사용
    */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
