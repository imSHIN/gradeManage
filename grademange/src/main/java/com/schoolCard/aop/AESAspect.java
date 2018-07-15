package com.schoolCard.aop;

import com.schoolCard.entity.Monitor;
import com.schoolCard.service.MonitorService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
@Aspect
public class AESAspect {
    @Resource
    private MonitorService monitorService;

    @Before(value = "execution(public * com.schoolCard.controller.*.*(..))" )
    public void beforeShow(JoinPoint jp) {
        String className = jp.getThis().toString();
        String methodName = jp.getSignature().getName();
        System.out.println("执行方法：类"+className+"，方法："+methodName);
    }


    @After(value = "execution(public * com.schoolCard.controller.*.*(..))")
    public void afterShow(JoinPoint jp) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        String requestURL = request.getRequestURI();
        Map<String, String[]> params = request.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // 去掉最后一个空格
        if (queryString.length() > 0) {
            queryString = queryString.substring(0, queryString.length() - 1);
        }
        System.out.println(request.getRequestURL() + " " + queryString);
        Monitor monitor = new Monitor();
        monitor.setUrl(ip);
        monitor.setApi(requestURL);
        monitor.setParams(queryString);

        if (params.get("studentid") == null){
            monitor.setStudentid(null);
        } else {
            String studentid = params.get("studentid")[0];
            monitor.setStudentid(studentid);
        }

        monitorService.insertMonitor(monitor);
    }
}
