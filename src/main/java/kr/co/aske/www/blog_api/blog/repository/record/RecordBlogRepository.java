package kr.co.aske.www.blog_api.blog.repository.record;

import kr.co.aske.www.blog_api.blog.domain.record.RecordBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordBlogRepository extends JpaRepository<RecordBlog, Long> {
}
