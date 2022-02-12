package kr.co.aske.www.blog_api.blog.controller;

import kr.co.aske.www.blog_api.blog.dto.blog.response.list.GetAllBlogDtoList;
import kr.co.aske.www.blog_api.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService service;

    /*
     * Read All
     */
    public GetAllBlogDtoList getAll(){
        return service.getAll();
    }

    /*
     * Read By id
     */

    /*
     * Create
     */

    /*
     * Update
     */

    /*
     * Delete
     */

}
