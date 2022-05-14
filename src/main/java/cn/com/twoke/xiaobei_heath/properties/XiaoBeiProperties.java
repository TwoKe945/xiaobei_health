package cn.com.twoke.xiaobei_heath.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>TODO</p>
 *
 * @author TwoKe
 * @version 1.0.0
 * @since 2022/5/14 22:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "xiaobei")
public class XiaoBeiProperties {

    private XiaobeiUser[] users;

    @Data
    public static class XiaobeiUser {
        private String username;
        private String password;
    }
}
