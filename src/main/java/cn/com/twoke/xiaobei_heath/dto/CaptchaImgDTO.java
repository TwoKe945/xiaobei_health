package cn.com.twoke.xiaobei_heath.dto;

import lombok.Data;

/**
 * @author TwoKe
 * @title: CaptchaImg
 * @projectName xiaobei_heath
 * @description: 验证码数据
 * @date 2022/5/1313:46
 */
@Data
public class CaptchaImgDTO extends ResultDTO {

    private String img;
    private String showCode;
    private String uuid;

}
