package kr.co.aske.www.blog_api.blog.service;

import kr.co.aske.www.blog_api.blog.domain.BlogCategory;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.GetAllBlogCategoryDto;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.SaveBlogCategoryDto;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.list.GetAllBlogCategoryDtoList;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.list.GetByIdBlogCategoryDtoList;
import kr.co.aske.www.blog_api.blog.repository.BlogCategoryRepository;
import kr.co.aske.www.blog_api.blog.repository.BlogCategoryRepositoryDsl;
import kr.co.aske.www.blog_api.blog.status.CategoryStatus;
import kr.co.aske.www.blog_api.user.domain.UserInfo;
import kr.co.aske.www.blog_api.util.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BlogCategoryService {
    private final BlogCategoryRepository repository;
    private final BlogCategoryRepositoryDsl repositoryDsl;

    public GetAllBlogCategoryDtoList getAll() {
        return repositoryDsl.getAll();
    }

    public GetByIdBlogCategoryDtoList getById(Long category) {
        return repositoryDsl.getById(category);
    }

    public ResponseDto save(String name, CategoryStatus status, UserInfo info) {
        // validate duple name
        if( repositoryDsl.existByName(name) ) throw new EntityExistsException("duplicate name : " + name);

        final Long id = repository.save(
                BlogCategory.builder()
                        .owner(info)
                        .name(name)
                        .status(status)
                        .isEnable(true)
                        .build()
        ).getId();

        return new ResponseDto(id);
    }

    public ResponseDto update(Long category, String name, CategoryStatus status, UserInfo info) {
        // validate not exist category
        if( !repositoryDsl.exist(category) ) throw new NullPointerException("not exist category id : " + category);

        // validate duple name
        if( repositoryDsl.existByNameAndNotId(name, category) ) throw new EntityExistsException("duplicate name : " + name);

        final Long id = repository.save(
                BlogCategory.builder()
                        .owner(info)
                        .name(name)
                        .status(status)
                        .isEnable(true)
                        .build()
        ).getId();

        return new ResponseDto(id);
    }

    public ResponseDto delete(Long category, UserInfo info) {
        // validate not exist category
        if( !repositoryDsl.exist(category) ) throw new NullPointerException("not exist category id : " + category);
        final BlogCategory blogCategory = repository.findById(category).orElseThrow(NullPointerException::new);

        final Long id = repository.save(
                BlogCategory.builder()
                        .id(blogCategory.getId())
                        .owner(blogCategory.getOwner())
                        .name(blogCategory.getName())
                        .status(blogCategory.getStatus())
                        .createAt(blogCategory.getCreateAt())
                        .isEnable(false)
                        .build()
        ).getId();

        return new ResponseDto(id);
    }
}
