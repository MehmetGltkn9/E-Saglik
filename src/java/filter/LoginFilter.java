/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import Entity.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author zafer
 */
@WebFilter("/*")
public class LoginFilter implements Filter{

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest) sr;
        HttpServletResponse res =(HttpServletResponse) sr1;
        
        String url = req.getRequestURI();
        
        User u = (User) req.getSession().getAttribute("valid_user");
        
        if(u == null){
            if(url.contains("doctor")){
               res.sendRedirect(req.getContextPath() + "/login.xhtml");
            }
            else{
                fc.doFilter(sr, sr1);
            }
        }
        else{
            if( url.contains("doctor")){
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            }
            else{
                fc.doFilter(sr, sr1);
            }
        }
    }
    
}
