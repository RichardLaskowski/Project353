  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import Controller.LoginController;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Richa
 */
public class LoginFilter implements Filter
{
    private FilterConfig filterconfig;
    
    @Override
    public void init(FilterConfig filterconfig) throws ServletException
    {
        this.filterconfig = filterconfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.println("LOGINFILTER: doFilter()");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        LoginController session = (LoginController) req.getSession().getAttribute("loginController");
        //System.out.println("LOGINFILTER: isLoggedIn = " + session.getIsLoggedIn());
        String url = req.getRequestURI();
        System.out.println("LOGINFILTER: requestURL = " + url);
        
        if(session == null || !session.getIsLoggedIn())
        {
            System.out.println("LOGINFILTER: session = null isLogginIn = null");
            if(url.indexOf("profile.xhtml") >= 0)
            {
                System.out.println("LOGINFILTER: requested profile.xhtml");
                resp.sendRedirect(req.getServletContext().getContextPath() + "/logIn.xhtml");
            }
//            else if(url.indexOf("details.xhtml") >= 0 || url.indexOf("recruiterDetails.xhtml") >= 0)
//            {
//                resp.sendRedirect(req.getServletContext().getContextPath() + "/signUp.xhtml");
//            }
            else
            {
                chain.doFilter(request, response);
            }
        }
        else
        {
            if(url.indexOf("details.xhtml") >= 0 || url.indexOf("recruiterDetails.xhtml") >= 0 || url.indexOf("signUp.xhtml") >= 0)
            {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/profile.xhtml");
            }
            else if(url.indexOf("logOut.xhtml") >= 0)
            {
                req.getSession().removeAttribute("LoginController");
                resp.sendRedirect(req.getServletContext().getContextPath() + "/logIn.xhtml");
            }
            else
            {
                chain.doFilter(request, response);
            }
        }
    
    }   
    
    @Override
    public void destroy()
    {
        
    }
    
}
