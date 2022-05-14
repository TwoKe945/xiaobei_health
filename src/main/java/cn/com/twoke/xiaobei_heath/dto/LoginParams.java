package cn.com.twoke.xiaobei_heath.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>TODO</p>
 *
 * @author TwoKe
 * @version 1.0.0
 * @since 2022/5/14 11:16
 */
@Data
@Accessors(chain = true)
public class LoginParams {

    private String username;
    private String password;
    private String uuid;
    private String code;

}
