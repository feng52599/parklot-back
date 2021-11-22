package edu.feng.parklotback.badduapi;

/**
 * @program: parklot-back
 * @description: 车牌识别接口调用
 * @author: feng
 * @create: 2020-02-14 14:55
 */

import org.apache.http.client.methods.CloseableHttpResponse;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangwenchao on 2017/9/29.
 */
public class PlateAPITest {

//    public static void main(String[] args) {
//        //  getToKenTest() ;
//        faceDetecttest();
//    }

    //获取token
    public static void getToKenTest(){

        //使用其测试百度云API---获取token
        //url: http://console.bce.baidu.com/ai

        String APPID ="18468375"; //管理中心获得

        //百度人脸识别应用apikey
        String API_KEY = "UrMsET9AoHSwQRglHe1aUazb"; //管理中心获得

        //百度人脸识别应用sercetkey
        String SERCET_KEY = "KEeLuqsmCt93dfzuqNzMetH25oB42aro"; //管理中心获得

        //百度人脸识别token 有效期一个月
        String TOKEN = null;


        String access_token_url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials"
                +"&client_id="+API_KEY +"&client_secret="+SERCET_KEY;

        CloseableHttpResponse response =  HttpClientUtils.doHttpsGet(access_token_url,null);

        System.out.println(HttpClientUtils.toString(response));


        //得到token = "access_token":"24.de607104ea4f86d8908ac291dddc6978.2592000.1584238589.282335-18468375"



    }

    //使用token调用API
    public static String plateDetect(String parkingPath){

//        String token = "24.a6b7ada46c4dec8283c7aef878efdf12.2592000.1589511212.282335-10201425";
        String token = "24.71649ef4604117bc78a1bbfcf17c261f.2592000.1589511816.282335-18468375";

        String Filepath = parkingPath;
        String image = Base64ImageUtils.GetImageStrFromPath(Filepath);
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/license_plate?access_token="+token;

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");

        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("image", image);
        bodys.put("face_fields", "age,beauty,expression,gender,glasses,race,qualities");
        JSONObject jsonObjectCopy = null;

        try {
            CloseableHttpResponse response =  HttpClientUtils.doHttpsPost(url,headers,bodys);
            // HttpClientUtils.toString 执行完毕后会关闭response
            String s = HttpClientUtils.toString(response);
            System.out.println("response："+ s);
            System.out.println("s" + s);
            JSONObject jsonObject = JSONObject.parseObject(s);
            jsonObjectCopy = jsonObject;
            System.out.println("jsonObject"+jsonObject);
            System.out.println("err"+jsonObjectCopy.getString("error_code"));
            JSONObject words_result = jsonObject.getJSONObject("words_result");
            String plate = words_result.getString("number");
            System.out.println("车牌：" + plate);
            return plate;
            // return platek;
        } catch (Exception e) {
            e.printStackTrace();
//            JSONObject words_result1 = jsonObjectCopy.getJSONObject("error_code");
            // 出现错误，返回错误吗
            System.out.println(jsonObjectCopy);
            String plate = jsonObjectCopy.getString("error_code");
            System.out.println("错误码：" + plate);
            return plate;
        }


    }

}

