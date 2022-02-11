package kr.co.aske.www.blog_api.user.service;

import kr.co.aske.www.blog_api.user.domain.UserInfo;
import kr.co.aske.www.blog_api.user.dto.request.ReqSaveUserDto;
import kr.co.aske.www.blog_api.user.dto.response.GetMyInfoUserDto;
import kr.co.aske.www.blog_api.user.repository.UserRepository;
import kr.co.aske.www.blog_api.user.repository.UserRepositoryDsl;
import kr.co.aske.www.blog_api.util.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityExistsException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final UserRepositoryDsl repositoryDsl;

    @Override
    public UserInfo loadUserByUsername(String Email) throws UsernameNotFoundException {
        return repositoryDsl.findByEmail(Email)
                .orElseThrow(EntityExistsException::new);
    }

    public GetMyInfoUserDto getMyInfoUserDto(UserInfo userInfo, CsrfToken token) {
        return new GetMyInfoUserDto(userInfo, token);
    }

    public ResponseDto save(String email, String password, String nickName, String roles) {
        if (repositoryDsl.existEmail(email)) throw new EntityExistsException("exist email : " + email);

        final Long id = repository.save(
                UserInfo.builder()
                        .email(email)
                        .password(new BCryptPasswordEncoder().encode(password))
                        .nickName(nickName)
                        .roles(Collections.singletonList(roles))
                        .isEnable(true)
                        .build()
        ).getId();
        return new ResponseDto(id);
    }
}
