package kr.co.aske.www.blog_api.blog.repository;

import kr.co.aske.www.blog_api.blog.domain.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {
}
