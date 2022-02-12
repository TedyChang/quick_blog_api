package kr.co.aske.www.blog_api.blog.dto.blogCategory.response;

import com.querydsl.core.annotations.QueryProjection;
import kr.co.aske.www.blog_api.blog.status.CategoryStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetAllBlogCategoryDto {
    private Long id;
    private String name;
    private CategoryStatus status;

    @QueryProjection
    public GetAllBlogCategoryDto(Long id, String name, CategoryStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
