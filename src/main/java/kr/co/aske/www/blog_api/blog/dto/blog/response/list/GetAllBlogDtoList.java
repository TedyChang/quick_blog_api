package kr.co.aske.www.blog_api.blog.dto.blog.response.list;

import kr.co.aske.www.blog_api.blog.dto.blog.response.GetAllBlogDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetAllBlogDtoList {
    List<GetAllBlogDto> list;

    public GetAllBlogDtoList(List<GetAllBlogDto> list) {
        this.list = list;
    }
}
