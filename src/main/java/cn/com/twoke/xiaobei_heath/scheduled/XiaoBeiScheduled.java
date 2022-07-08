package cn.com.twoke.xiaobei_heath.scheduled;

import cn.com.twoke.http.creator.FaceCreator;
import cn.com.twoke.xiaobei_heath.dto.CaptchaImgDTO;
import cn.com.twoke.xiaobei_heath.dto.LoginDTO;
import cn.com.twoke.xiaobei_heath.dto.LoginParams;
import cn.com.twoke.xiaobei_heath.dto.RequestData;
import cn.com.twoke.xiaobei_heath.properties.XiaoBeiProperties;
import cn.com.twoke.xiaobei_heath.service.XiaoBeiApi;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>定时任务</p>
 *
 * @author TwoKe
 * @version 1.0.0
 * @since 2022/5/14 22:21
 */
@Service
public class XiaoBeiScheduled {

    @Autowired
    private XiaoBeiProperties xiaoBeiProperties;
    @Resource
    private XiaoBeiApi xiaoBeiApi;

//  0 0 7 * * ? 每天7点定时打卡
    @Scheduled(cron = "0 8 10 * * ?") // 22:44定时打卡
    public void doHeath() {
        XiaoBeiProperties.XiaobeiUser[] users = xiaoBeiProperties.getUsers();
        for (XiaoBeiProperties.XiaobeiUser user : users) {
            mockHeath(user.getUsername(), user.getPassword());
        }
        System.out.println(new Date());
    }

    public void mockHeath(String username, String password) {
//      获取验证码
        CaptchaImgDTO captchaImage = xiaoBeiApi.getCaptchaImage();
        String code = captchaImage.getShowCode();
        String uuid = captchaImage.getUuid();
//      登录小北
        LoginDTO loginDTO = xiaoBeiApi.login(new LoginParams()
                .setUsername(username)
                .setPassword(Base64.encodeBase64String(password.getBytes()))
                .setCode(code)
                .setUuid(uuid)
        );
//      获取token
        String token = loginDTO.getToken();
//      生成随机温度
        double temperature = new BigDecimal(35.7 + Math.random()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
//      小北温度打卡
        xiaoBeiApi.doHealth(new RequestData()
                .setTemperature(temperature + "")
                .setLocation("105.933807,29.320102")
                .setCoordinates("中国-重庆市-重庆市-永川区")
                .setHealthState("1")
                .setDangerousRegion("2")
                .setContactSituation("2")
                .setGoOut("1")
                .setFamilySituation("1"), "Bearer " + token);
    }

}
