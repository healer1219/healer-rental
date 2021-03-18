package com.healer.user.service;

import com.alibaba.fastjson.JSON;
import com.healer.common.utils.HttpUtils;
import com.healer.user.domain.DriverLicense;
import com.healer.user.domain.RealName;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 李泽炜
 * @package com.healer.user.service
 * @time 2021/3/1 10:10
 * @Description TODO
 */
@Service
public class RealNameService {
    @Autowired
    private HttpUtils httpUtils;


    private static final String url = "https://mobile3elements.shumaidata.com/mobile/verify_real_name";
    private static final String appCode = "21aecf4ced69411888be2f9f711e8fd6";


    public  RealName isRealName(String name, String phone, String num) throws IOException {
//        String url = "https://mobile3elements.shumaidata.com/mobile/verify_real_name";
//        String appCode = "21aecf4ced69411888be2f9f711e8fd6";
        Map<String,String> params = new HashMap<>();
        params.put("idcard",num);
        params.put("mobile",phone);
        params.put("name",name);
        String result =  postForm(appCode,url,params);
        //获取到结果转化为对象
        RealName realName = JSON.parseObject(result,RealName.class);

        System.out.println(realName.toString());

        return realName;
    }

//    public static void main(String[] args) throws IOException {
//        RealName re = isRealName("李泽炜", "123456678", "140202199812193510");
//        System.out.println(re.getResult());
//    }



    /**
     * 用于实名认证
     * @param appCode 授权码
     * @param url  地址
     * @param params    实名认证三要素
     * @return
     * @throws IOException
     */
    public static String postForm(String appCode, String url, Map<String, String> params) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();
        FormBody.Builder formbuilder = new FormBody.Builder();
        Iterator<String> it = params.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            formbuilder.add(key,params.get(key));
        }
        FormBody body = formbuilder.build();
        Request request = new Request.Builder().url(url).addHeader("Authorization","APPCODE "+appCode).post(body).build();
        Response response = client.newCall(request).execute();
        System.out.println("返回状态码"+response.code()+",message:"+response.message());
        String result =  response.body().string();
        return result;
    }




}
