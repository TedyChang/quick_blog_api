package kr.co.aske.www.blog_api.blog.dto.blogCategory.response.list;

import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.GetByIdBlogCategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetByIdBlogCategoryDtoList {
    List<GetByIdBlogCategoryDto> list;

    public GetByIdBlogCategoryDtoList(List<GetByIdBlogCategoryDto> list) {
        this.list = list;
    }
}
