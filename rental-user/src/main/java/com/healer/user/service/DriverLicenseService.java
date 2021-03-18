package com.healer.user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.healer.common.utils.HttpUtils;
import com.healer.common.utils.JSONChange;
import com.healer.user.domain.DriverLicense;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.codec.binary.Base64.encodeBase64;


/**
 * 使用APPCODE进行云市场ocr服务接口调用
 */
@Service
public class DriverLicenseService {
    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private JSONChange jsonChange;
    /*
     * 获取参数的json对象
     */
    public static JSONObject getParam(int type, String dataValue) {

        JSONObject obj = new JSONObject();
        try {
            obj.put("dataType", type);
            obj.put("dataValue", dataValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public DriverLicense getDriveLicense(String img){
        String host = "https://dm-52.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_driver_license.json";
        String appcode = "21aecf4ced69411888be2f9f711e8fd6";
        String imgFile = img;
        //请根据线上文档修改configure字段
        JSONObject configObj = new JSONObject();
        configObj.put("side", "face");
        String config_str = configObj.toString();
        //            configObj.put("min_size", 5);
        //            String config_str = "";

        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359d73e9498385570ec139105
        headers.put("Authorization", "APPCODE " + appcode);

        Map<String, String> querys = new HashMap<String, String>();

        // 对图像进行base64编码
        String imgBase64 = "";
        try {
            if(imgFile.startsWith("http")){
                imgBase64 = imgFile;
            }else {
                File file = new File(imgFile);
                byte[] content = new byte[(int) file.length()];
                FileInputStream finputstream = new FileInputStream(file);
                finputstream.read(content);
                finputstream.close();
                imgBase64 = new String(encodeBase64(content));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("image", imgBase64);
            if(config_str.length() > 0) {
                requestObj.put("configure", config_str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String bodys = requestObj.toString();

        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                System.out.println("Http code: " + stat);
                System.out.println("http header error msg: "+ response.getFirstHeader("X-Ca-Error-Message"));
                System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
                return null;
            }

            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);
            DriverLicense driverLicense = (DriverLicense) jsonChange.jsonToObj(new DriverLicense(), res_obj.toJSONString());
            System.out.println(driverLicense);
            //System.out.println(res_obj.toJSONString());
            return driverLicense;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

