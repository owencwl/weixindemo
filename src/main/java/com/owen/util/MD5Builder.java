package com.owen.util;

import java.security.MessageDigest;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by owen on 2017/3/6.
 */
public class MD5Builder {


        public static String build(String origin ,String charsetName){
            if(origin == null )
                return null ;

            StringBuilder sb = new StringBuilder() ;
            MessageDigest digest = null ;
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null ;
            }

            //生成一组length=16的byte数组
            byte[] bs = digest.digest(origin.getBytes(Charset.forName(charsetName))) ;

            for (int i = 0; i < bs.length; i++) {
                int c = bs[i] & 0xFF ; //byte转int为了不丢失符号位， 所以&0xFF
                if(c < 16){ //如果c小于16，就说明，可以只用1位16进制来表示， 那么在前面补一个0
                    sb.append("0");
                }
                sb.append(Integer.toHexString(c)) ;
            }
            return sb.toString() ;
        }


}
