package kr.co.aske.www.blog_api.blog.domain;

import kr.co.aske.www.blog_api.blog.status.BlogStatus;
import kr.co.aske.www.blog_api.user.domain.UserInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blog")
public class Blog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category")
    private BlogCategory category;

    @ManyToOne
    @JoinColumn(name = "owner")
    private UserInfo owner;

    @Column(name = "status")
    private BlogStatus status;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    @Column(name = "is_enable")
    private Boolean isEnable = true;

    public Blog(Long id, BlogCategory category, UserInfo owner, BlogStatus status, LocalDateTime createAt, LocalDateTime updateAt, Boolean isEnable) {
        this.id = id;
        this.category = category;
        this.owner = owner;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.isEnable = isEnable;
    }
}
