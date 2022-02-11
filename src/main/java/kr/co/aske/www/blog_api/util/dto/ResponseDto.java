package kr.co.aske.www.blog_api.util.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
    private Long id;
    private String message;

    public ResponseDto(Long id) {
        this.id = id;
        this.message = "success";
    }
}
