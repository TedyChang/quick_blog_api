package kr.co.aske.www.blog_api.blog.domain;

/*
 * 블로그가 포함하는 카테고리입니다.
 * 크게 일반, 테스트로 구분합니다.
 */

import kr.co.aske.www.blog_api.blog.status.CategoryStatus;
import kr.co.aske.www.blog_api.user.domain.UserInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blog_category")
@Getter
public class BlogCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner")
    private UserInfo owner;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private CategoryStatus status;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    @Column(name = "is_enable")
    private Boolean isEnable = true;

    @Builder
    public BlogCategory(Long id, UserInfo owner, String name, CategoryStatus status, LocalDateTime createAt, LocalDateTime updateAt, Boolean isEnable) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.isEnable = isEnable;
    }
}
