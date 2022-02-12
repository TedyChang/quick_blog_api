package kr.co.aske.www.blog_api.blog.service;

import kr.co.aske.www.blog_api.blog.dto.blog.response.list.GetAllBlogDtoList;
import kr.co.aske.www.blog_api.blog.repository.BlogRepository;
import kr.co.aske.www.blog_api.blog.repository.BlogRepositoryDsl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository repository;
    private final BlogRepositoryDsl repositoryDsl;

    public GetAllBlogDtoList getAll() {
        return null;
    }
}
