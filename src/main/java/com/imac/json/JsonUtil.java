package com.imac.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonUtil {

    public static void main(String[] args) {
//        Persion persion = new Persion();
//        persion.setId(1L);
//        persion.setName("test");
//
//        Response<Persion> response = new Response<>();
//
//        response.setResultCode("0000");
//        response.setResultMsg("success");
//        response.setData(persion);
//
//        String str = JSON.toJSONString(response);

        String str1 = "{\"data\":{\"id\":1,\"name\":\"test\"},\"resultCode\":\"0000\",\"resultMsg\":\"success\"}";

        Response<Persion> response = parseToMap(str1, Persion.class);

//        response = (Response<Persion>) JSON.parseObject(str1, new TypeReference<Response<Persion>>(){});

        System.out.println(response);

        Persion persion1 = response.getData();

        System.out.println(persion1);
    }

    public static <T> Response<T> parseToMap(String json, Class<T> type) {
         return JSON.parseObject(json, new TypeReference<Response<T>>(type) {});
    }
}
