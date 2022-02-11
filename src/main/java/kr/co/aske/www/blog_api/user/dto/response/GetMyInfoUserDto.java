package kr.co.aske.www.blog_api.user.dto.response;

import kr.co.aske.www.blog_api.user.domain.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.web.csrf.CsrfToken;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetMyInfoUserDto {
    private Long id;

    private String nickName;

    private String email;

    private List<String> roles;

    private CsrfToken token;

    public GetMyInfoUserDto(UserInfo userInfo) {
        this.id = userInfo.getId();
        this.nickName = userInfo.getNickName();
        this.email = userInfo.getEmail();
        this.roles = userInfo.getRoles();
    }

    public GetMyInfoUserDto(UserInfo userInfo, CsrfToken token) {
        this.id = userInfo.getId();
        this.nickName = userInfo.getNickName();
        this.email = userInfo.getEmail();
        this.roles = userInfo.getRoles();

        this.token = token;
    }
}
