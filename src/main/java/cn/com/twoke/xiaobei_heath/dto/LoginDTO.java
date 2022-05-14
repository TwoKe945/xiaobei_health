package cn.com.twoke.xiaobei_heath.dto;

import lombok.Data;

/**
 * @author TwoKe
 * @title: LoginResponseDto
 * @projectName xiaobei_heath
 * @description: 登录结果
 * @date 2022/5/1314:38
 */
@Data
public class LoginDTO extends ResultDTO {

    private String token;

}
