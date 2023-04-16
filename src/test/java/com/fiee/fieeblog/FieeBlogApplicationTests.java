package com.fiee.fieeblog;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.fiee.fieeblog.entity.UserRole;
import com.fiee.fieeblog.service.UserAuthService;
import com.fiee.fieeblog.service.UserInfoService;
import com.fiee.fieeblog.service.UserRoleService;
import com.fiee.fieeblog.utils.OssUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class FieeBlogApplicationTests {
    //    @Autowired
//    private UserRoleService userRoleService;
//    @Test
//    void contextLoads() {
//        List<UserRole> list = new ArrayList<>();
//        for (int i=1739;i<1790;i++){
//            UserRole userRole = new UserRole();
//            userRole.setUserId(i);
//            userRole.setRoleId(1);
//            list.add(userRole);
//        }
//        userRoleService.saveBatch(list);
//    }
//    @Value("${aliyun.oss.endpoint}")
//    public String endpoint;
//    @Value("${aliyun.oss.accessKeySecret}")
//    public String accessKeySecret;
//    @Value("${aliyun.oss.accessKeyId}")
//    public String accessKeyId;
//    @Value("${aliyun.oss.bucketName}")
//    public String bucketName;
    @Autowired
    private UserAuthService userAuthService;
    @Test
    public void getOssToken() throws UnsupportedEncodingException {
    //        OssUtils ossUtils = new OssUtils();
    //        Map ossToken = ossUtils.getOssToken(endpoint,accessKeyId, accessKeySecret,bucketName);
    //        System.out.println(ossToken);
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//        String host = "https://" + bucketName + "." + endpoint;
//        Map<String, String> respMap = new LinkedHashMap<>();
//        long expireTime = 30;
//        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
//        Date expiration = new Date(expireEndTime);
//
//        PolicyConditions policyConds = new PolicyConditions();
//        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
//        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, "avatar/");
//        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
//        byte[] binaryData = postPolicy.getBytes("utf-8");
//        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
//        String postSignature = ossClient.calculatePostSignature(postPolicy);
//        respMap.put("accessKeyId", "LTAI5tDjnQkzfmBZ8kJSjaak");
//        respMap.put("policy", encodedPolicy);
//        respMap.put("signature", postSignature);
//        respMap.put("dir", "avatar/");
//        respMap.put("host", host);
//        respMap.put("expire", String.valueOf(expireEndTime / 1000));
//        ossClient.shutdown();
//        System.out.println(respMap);
    }
    @Test
    public void test(){
        Map map = new HashMap<>();
        map.put("id",1);
        map.put("old_password","123456");
//        map.put("id",1);
//        map.put("id",1);
        userAuthService.updateUserInfo(map);
    }
}
