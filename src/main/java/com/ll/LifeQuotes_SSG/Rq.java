package com.ll.LifeQuotes_SSG;

import java.util.Arrays;

public class Rq {
    String queryStr;
    String path;
    public String url;
    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        if ( urlBits.length == 2 ) {
            this.queryStr = urlBits[1];
        }
        //"?"를 기준으로 2덩어리로 나눌 것.

    }

    public int getIntParam(String paramName, int defaultValue) {


        //?뒤에 내용이 아예없다면.
        if( queryStr == null ) {// 뒤에 내용에 해당하는 쿼리스트링이 비어있다면,
            return defaultValue;
        }
        String[] bits = queryStr.split("&");
        //나눠진 두 덩어리 중 뒤에를 & 기준으로 나눈다.

        for (String urlBit : bits){//향상된 for문
            String[] paramNameAndValue = urlBit.split("=",2);
            //파라미터를 name과 value로 나누는 작업
            String paramName_ = paramNameAndValue[0];
            String paraValue = paramNameAndValue[1];

            if( paramName.equals(paramName_)){
                return Integer.parseInt(paraValue);
                //반환형이 Int이기 때문에 정수화를 시킨다.
            }
        }
        return defaultValue;
    }

    public String getPath() {
        return path;
    }
}
