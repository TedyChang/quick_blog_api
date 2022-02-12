package kr.co.aske.www.blog_api.blog.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.aske.www.blog_api.blog.domain.BlogCategory;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.QGetAllBlogCategoryDto;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.QGetByIdBlogCategoryDto;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.list.GetAllBlogCategoryDtoList;
import kr.co.aske.www.blog_api.blog.dto.blogCategory.response.list.GetByIdBlogCategoryDtoList;
import kr.co.aske.www.blog_api.user.domain.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static kr.co.aske.www.blog_api.blog.domain.QBlogCategory.blogCategory;
import static kr.co.aske.www.blog_api.user.domain.QUserInfo.userInfo;

@RequiredArgsConstructor
@Repository
public class BlogCategoryRepositoryDsl {
    private final JPAQueryFactory queryFactory;

    public GetAllBlogCategoryDtoList getAll() {
        return new GetAllBlogCategoryDtoList(
                queryFactory
                        .select(
                                new QGetAllBlogCategoryDto(
                                        blogCategory.id,
                                        blogCategory.name,
                                        blogCategory.status
                                )
                        )
                        .from(blogCategory)
                        .where(blogCategory.isEnable.eq(true))
                        .fetch()
        );
    }

    public GetByIdBlogCategoryDtoList getById(Long category) {
        return new GetByIdBlogCategoryDtoList(
                queryFactory
                        .select(
                                new QGetByIdBlogCategoryDto(
                                        blogCategory.id,
                                        blogCategory.name,
                                        blogCategory.status,
                                        blogCategory.createAt,
                                        blogCategory.updateAt
                                )
                        )
                        .from(blogCategory)
                        .where(
                                blogCategory.isEnable.eq(true),
                                blogCategory.id.eq(category)
                        )
                        .fetch()
        );
    }


    @Transactional(readOnly = true)
    public Boolean exist(Long id) {
        BlogCategory fetchOne = queryFactory
                .selectFrom(blogCategory)
                .where(
                        blogCategory.isEnable.eq(true),
                        blogCategory.id.eq(id)
                )
                .fetchFirst();
        return null != fetchOne;
    }

    @Transactional(readOnly = true)
    public Boolean existByName(String name) {
        BlogCategory fetchOne = queryFactory
                .selectFrom(blogCategory)
                .where(
                        blogCategory.isEnable.eq(true),
                        blogCategory.name.eq(name)
                )
                .fetchFirst();
        return null != fetchOne;
    }

    public Boolean existByNameAndNotId(String name, Long category) {
        BlogCategory fetchOne = queryFactory
                .selectFrom(blogCategory)
                .where(
                        blogCategory.isEnable.eq(true),
                        blogCategory.name.eq(name),
                        blogCategory.id.ne(category)
                )
                .fetchFirst();
        return null != fetchOne;
    }
}
