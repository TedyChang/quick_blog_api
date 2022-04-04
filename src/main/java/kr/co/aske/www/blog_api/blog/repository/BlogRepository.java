package kr.co.aske.www.blog_api.blog.repository;

import kr.co.aske.www.blog_api.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
