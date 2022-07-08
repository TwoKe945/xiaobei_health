package cn.com.twoke.xiaobei_heath.service;

import cn.com.twoke.http.annotation.*;
import cn.com.twoke.http.annotation.mapping.PostMapping;
import cn.com.twoke.http.annotation.mapping.RequestMapping;
import cn.com.twoke.xiaobei_heath.dto.CaptchaImgDTO;
import cn.com.twoke.xiaobei_heath.dto.LoginDTO;
import cn.com.twoke.xiaobei_heath.dto.LoginParams;
import cn.com.twoke.xiaobei_heath.dto.RequestData;

/**
 * @author TwoKe
 * @title: XiaoBeiApi
 * @projectName xiaobei_heath
 * @description: 小北Api接口
 * @date 2022/5/1313:28
 */
@ServiceClient(value ="https://xiaobei.yinghuaonline.com/xiaobei-api", headers = {
        @Header(name = "User-Agent", value = "iPhone10,3(iOS/14.4) Uninview(Uninview/1.0.0) Weex/0.26.0 1125x2436"),
        @Header(name = "Content-Type", value = "application/json; charset=utf-8"),
        @Header(name = "Host", value = "xiaobei.yinghuaonline.com"),
        @Header(name = "Connection", value = "Keep-Alive"),
        @Header(name = "Accept-Encoding", value = "gzip")
})
public interface XiaoBeiApi {

    /**
     * 小北登录
     * @return
     */
    @PostMapping(value = "/login")
    LoginDTO login(@Body LoginParams loginParams);

    /**
     * 获取验证码
     * @return
     */
    @RequestMapping(value = "/captchaImage")
    CaptchaImgDTO getCaptchaImage();

    /**
     * 温度打卡
     * @return
     */
    @PostMapping(value = "/student/health")
    String doHealth(@Body RequestData requestData, @Header(name = "Authorization") String token);
}
