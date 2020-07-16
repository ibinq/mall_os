package com.bing.mall_app.config;

import com.bing.mall_common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author ZhouBing
 * @version 1.0
 * @date 2020/7/8 7:21
 */
@Configuration
public class TokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if(!request.getRequestURI().contains("/login")){

            Enumeration<String> names = request.getHeaderNames();
            String token = request.getHeader("authorization");
            Claims claims = null;
            try {
                claims = Jwts.parser()
                        .setSigningKey("zhoubing")
                        .parseClaimsJws(token)
                        .getBody();
                Object username = claims.get("username");
                System.out.println(username);
                String uid = claims.get("id").toString();


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }

}
