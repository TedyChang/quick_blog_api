package kr.co.aske.www.blog_api.blog.dto.blogCategory.response.list;

import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.GetAllBlogCategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetAllBlogCategoryDtoList {
    List<GetAllBlogCategoryDto> list;

    public GetAllBlogCategoryDtoList(List<GetAllBlogCategoryDto> list) {
        this.list = list;
    }
}
