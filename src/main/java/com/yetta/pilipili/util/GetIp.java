package com.yetta.pilipili.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class GetIp {
    public static String getIp(HttpServletRequest request){
        String ip=request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip)&&!"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后,会有多个IP值,第一个IP值才是真实的IP
            int index=ip.indexOf(".");
            if (index!=-1){
                return ip.substring(0,index);
            }else return ip;
        }
        ip=request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(ip)&&!"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
}
