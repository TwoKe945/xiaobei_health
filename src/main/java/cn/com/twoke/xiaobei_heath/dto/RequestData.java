package cn.com.twoke.xiaobei_heath.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author TwoKe
 * @title: Request
 * @projectName xiaobei_heath
 * @description: TODO
 * @date 2022/5/1314:45
 */

@Data
@Accessors(chain = true)
public class RequestData {

     String temperature ;
     String coordinates;
     String location;
     String healthState;
     String dangerousRegion;
     String dangerousRegionRemark;
     String contactSituation;
     String goOut;
     String goOutRemark;
     String remark;
     String familySituation;

}
