package com.fiee.fieeblog.filter;

import com.fiee.fieeblog.exception.BizException;
import com.fiee.fieeblog.utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JwtInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String s = request.getHeader("Authorization");
        String token = "";
        if (s != null ){
            String[] split = s.split(" ");
            token = split[1];
        }
        //解析token
        try {
            JwtUtil.parseJWT(token);
        } catch (Exception e) {
            throw new BizException("无效的Token");
        }
        //放行
        return true;
    }
    //TODO
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////        System.out.println(request.getRequestURI());
////        if (request.getRequestURI().equals("/doc.html")){
////            filterChain.doFilter(request,response);
////        }
//        //获取token Authorization
//        String s = request.getHeader("Authorization");
//        String token = "";
//        if (s != null ){
//            String[] split = s.split(" ");
//            token = split[1];
//        }else {
//            filterChain.doFilter(request,response);
//            return;
//        }
//        //解析token
//        try {
//            JwtUtil.parseJWT(token);
//        } catch (Exception e) {
//
////            e.printStackTrace();
//            throw new BizException(e.getMessage());
//        }
//        //放行
//        filterChain.doFilter(request,response);
//    }
}
