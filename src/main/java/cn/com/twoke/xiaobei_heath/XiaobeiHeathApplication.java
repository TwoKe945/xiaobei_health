package cn.com.twoke.xiaobei_heath;

import cn.com.twoke.xiaobei_heath.properties.XiaoBeiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({
  XiaoBeiProperties.class,
})
public class XiaobeiHeathApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaobeiHeathApplication.class, args);
    }

}
