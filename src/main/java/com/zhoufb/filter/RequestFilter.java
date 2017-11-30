package com.zhoufb.filter;


import com.alibaba.dubbo.rpc.RpcContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/7.
 */
public class RequestFilter implements ContainerRequestFilter{

    public void filter(ContainerRequestContext req) throws IOException {

        if (RpcContext.getContext().getRequest() != null && RpcContext.getContext().getRequest() instanceof HttpServletRequest) {
//            System.out.println("Client address is " + ((HttpServletRequest) RpcContext.getContext().getRequest()).getSession());
            HttpSession session = RpcContext.getContext().getRequest(HttpServletRequest.class).getSession();
            System.out.println(session.getAttribute("userid"));
            session.setAttribute("userid","123456789");

        }
        Map<String,Cookie> map = req.getCookies();
        map.forEach((x,y)->System.out.println(x+"|"+y));
    }
}
