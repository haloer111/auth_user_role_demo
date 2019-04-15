package com.gexiao.demo.util;

import com.gexiao.demo.common.UserConstant;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @Auther: gexiao
 * @Date: 2019/4/12 09:52
 * @Description:
 */
public class UserUtil {

    public static String getCurrentUserId() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (attributes != null)
            return (String) attributes.getAttribute(UserConstant.USER_ID, RequestAttributes.SCOPE_REQUEST);
        return null;
    }
}
