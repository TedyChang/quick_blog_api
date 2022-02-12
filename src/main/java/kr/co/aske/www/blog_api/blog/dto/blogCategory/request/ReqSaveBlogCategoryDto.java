package kr.co.aske.www.blog_api.blog.dto.blogCategory.request;

import kr.co.aske.www.blog_api.blog.status.CategoryStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReqSaveBlogCategoryDto {
    private String name;
    private CategoryStatus status;

    public ReqSaveBlogCategoryDto(String name, CategoryStatus status) {
        this.name = name;
        this.status = status;
    }
}
