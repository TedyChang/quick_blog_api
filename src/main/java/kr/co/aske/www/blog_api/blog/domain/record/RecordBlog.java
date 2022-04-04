package kr.co.aske.www.blog_api.blog.domain.record;

import kr.co.aske.www.blog_api.blog.domain.Blog;
import kr.co.aske.www.blog_api.blog.status.BlogStatus;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

/*
 * Blog record
 * 블로그 Data 수정 시, 로그를 대신해 저장합니다.
 * Only Save, Read
 */

@Entity
@NoArgsConstructor
@Table(name = "record__blog")
public class RecordBlog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blog", nullable = true, insertable = false, updatable = false)
    private Blog blog;

    @Column(name = "blog_id", nullable = true, insertable = false, updatable = false)
    private Long blog_id;

    @Column(name = "blog_category_id", nullable = true, insertable = false, updatable = false)
    private Long blog_category_id;

    @Column(name = "blog_owner_id", nullable = true, insertable = false, updatable = false)
    private Long blog_owner_id;

    @Column(name = "blog_status", nullable = true, insertable = false, updatable = false)
    private BlogStatus blog_status;

    @Column(name = "blog_create_at", nullable = true, insertable = false, updatable = false)
    private LocalDateTime blog_createAt;

    @Column(name = "blog_update_at", nullable = true, insertable = false, updatable = false)
    private LocalDateTime blog_updateAt;

    @Column(name = "blog_is_enable", nullable = true, insertable = false, updatable = false)
    private Boolean blog_isEnable;

    @CreationTimestamp
    private LocalDateTime createAt;

    @Builder
    public RecordBlog(Long id, Blog blog, Long blog_id, Long blog_category_id, Long blog_owner_id, BlogStatus blog_status, LocalDateTime blog_createAt, LocalDateTime blog_updateAt, Boolean blog_isEnable, LocalDateTime createAt) {
        this.id = id;
        this.blog = blog;
        this.blog_id = blog_id;
        this.blog_category_id = blog_category_id;
        this.blog_owner_id = blog_owner_id;
        this.blog_status = blog_status;
        this.blog_createAt = blog_createAt;
        this.blog_updateAt = blog_updateAt;
        this.blog_isEnable = blog_isEnable;
        this.createAt = createAt;
    }
}
