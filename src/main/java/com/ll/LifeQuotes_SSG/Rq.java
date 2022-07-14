package com.ll.LifeQuotes_SSG;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rq {
    String path;
    public String url;
    Map<String, String> queryParams;
    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        queryParams = new HashMap<>();

        if ( urlBits.length == 2 ) {
            String queryStr = urlBits[1];

            String[] paramBits = queryStr.split("&");

            for( String paramBit : paramBits ) {
                String[] paramNameAndValue = paramBit.split("=",2);

                if ( paramNameAndValue.length == 1 ) {
                    continue;
                }//만약 value값에 아무것도 들어오지 않았다면?

                String paramName = paramNameAndValue[0].trim();
                String paramValue = paramNameAndValue[1].trim();

                queryParams.put(paramName, paramValue);
            }
        }
        //"?"를 기준으로 2덩어리로 나눌 것.
    }

    public int getIntParam(String paramName, int defaultValue) {
        if ( queryParams.containsKey(paramName) == false){// containskey는 안에 paraName이 있는지 확인하는 메서드
            return defaultValue;
        }

        String paramValue = queryParams.get(paramName);

        if ( paramValue.length() == 0){
            return defaultValue;
        }
        return Integer.parseInt(queryParams.get(paramName));
    }

    public String getPath() {
        return path;
    }
}
