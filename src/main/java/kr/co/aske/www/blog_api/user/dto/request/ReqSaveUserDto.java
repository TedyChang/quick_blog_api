package kr.co.aske.www.blog_api.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqSaveUserDto {
    private String nickName;
    private String email;
    private String password;
    private String roles;

}
