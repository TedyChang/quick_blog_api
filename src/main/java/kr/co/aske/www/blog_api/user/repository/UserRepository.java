package kr.co.aske.www.blog_api.user.repository;

import kr.co.aske.www.blog_api.user.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
}
