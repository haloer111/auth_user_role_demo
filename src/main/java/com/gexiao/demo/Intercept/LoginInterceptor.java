package com.gexiao.demo.Intercept;

import com.alibaba.fastjson.JSONObject;
import com.gexiao.demo.common.Result;
import com.gexiao.demo.config.GatewayParams;
import com.gexiao.demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 登录拦截器,用于鉴权
 *
 * @Auther: gexiao
 * @Date: 2019/4/10 16:22
 * @Description:
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private GatewayParams gatewayParams;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("请求uri = " + uri);

        // 是否需要拦截
        if (isIntercept(uri))
            return true;

        //从token中获取用户信息
        JWTUtil.UserInfo user = JWTUtil.getUserByRequest(request);
        if (user == null) {
            respondToClientMsg(response, "token异常");
            return false;
        }

        //校验用户的权限


        return false;
    }

    /**
     * 响应给客户端内容
     * @param response
     * @param msg 响应内容
     * @throws IOException
     */
    private void respondToClientMsg(HttpServletResponse response, String msg) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(JSONObject.toJSONString(Result.fail(msg)));
    }

    /**
     * 是否需要拦截uri
     */
    private boolean isIntercept(String uri) {
        boolean flag = false;
        for (String unchecked : gatewayParams.getUnchecked()) {
            if (unchecked.equals(uri))
                flag = true;
        }
        return flag;
    }
}
