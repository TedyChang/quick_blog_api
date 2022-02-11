package kr.co.aske.www.blog_api.user.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import kr.co.aske.www.blog_api.annotation.LoginUser;
import kr.co.aske.www.blog_api.user.domain.UserInfo;
import kr.co.aske.www.blog_api.user.dto.request.ReqSaveUserDto;
import kr.co.aske.www.blog_api.user.dto.response.GetMyInfoUserDto;
import kr.co.aske.www.blog_api.user.service.UserService;
import kr.co.aske.www.blog_api.util.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService service;


    @GetMapping(value = "/token")
    public HashMap<String, Object> getToken(CsrfToken token) {
        return Maps.newHashMap(ImmutableMap.of(
                "token", token
        ));
    }

    @GetMapping(value = "")
    public GetMyInfoUserDto getMyInfoUserDto(@LoginUser UserInfo userInfo, CsrfToken token) {
        return service.getMyInfoUserDto(userInfo, token);
    }

    @PostMapping(value = "")
    public ResponseDto signup(
            ReqSaveUserDto dto) {
        return service.save(dto.getEmail(), dto.getPassword(), dto.getNickName(), dto.getRoles());

    }


}
