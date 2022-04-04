package kr.co.aske.www.blog_api.blog.dto.blogCategory.response;

import com.querydsl.core.annotations.QueryProjection;
import kr.co.aske.www.blog_api.blog.status.CategoryStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class GetByIdBlogCategoryDto {
    private Long id;
    private String name;

    private CategoryStatus status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @QueryProjection
    public GetByIdBlogCategoryDto(Long id, String name, CategoryStatus status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
