package kr.co.aske.www.blog_api.blog.controller;

import kr.co.aske.www.blog_api.annotation.LoginUser;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.request.ReqSaveBlogCategoryDto;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.request.ReqUpdateBlogCategoryDto;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.SaveBlogCategoryDto;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.list.GetAllBlogCategoryDtoList;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.list.GetByIdBlogCategoryDtoList;
import kr.co.aske.www.blog_api.blog.service.BlogCategoryService;
import kr.co.aske.www.blog_api.user.domain.UserInfo;
import kr.co.aske.www.blog_api.util.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class BlogCategoryController {
    private final BlogCategoryService service;

    /*
     * Read All
     */
    @GetMapping(value = "/blogs/categories")
    public GetAllBlogCategoryDtoList getAll(){
        return service.getAll();
    }

    /*
     * Read By id
     */
    @GetMapping(value = "/blogs/categories/{category}")
    public GetByIdBlogCategoryDtoList getById(@PathVariable Long category){
        return service.getById(category);
    }

    /*
     * Create
     */
    @PostMapping(value = "/blogs/categories")
    public ResponseDto save(
            ReqSaveBlogCategoryDto dto,
            @LoginUser UserInfo info
            ){
        return service.save(dto.getName(), dto.getStatus(), info);
    }

    /*
     * Update
     */
    @PutMapping(value = "/blogs/categories/{category}")
    public ResponseDto update(
            @PathVariable Long category,
            ReqUpdateBlogCategoryDto dto,
            @LoginUser UserInfo info
    ){
        return service.update(category, dto.getName(), dto.getStatus(), info);
    }

    /*
     * Delete
     */
    @DeleteMapping(value = "/blogs/categories/{category}" )
    public ResponseDto delete(
            @PathVariable Long category,
            @LoginUser UserInfo info
    ){
        return service.delete(category, info);
    }


}
