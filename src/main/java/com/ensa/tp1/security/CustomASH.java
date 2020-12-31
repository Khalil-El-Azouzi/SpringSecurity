package com.ensa.tp1.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

@Component
public class CustomASH implements AuthenticationSuccessHandler {

/*    @Override //version StackOverFlow
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("admin/**"); // on peut pas l'utilisé car on traite la sécurité et pas une
        }else if(roles.contains("ROLE_USER")){
            response.sendRedirect("user/**");
        }
    }*/

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException{
        String rs = null;
        //le type de collection est touts les sous types possible de GrantedAuthorities
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(GrantedAuthority ga : authorities) {
            if (ga.getAuthority().equals("ROLE_USER")) {
                rs = "/user/dashboard";
                break;
            } else if (ga.getAuthority().equals("ROLE_ADMIN")) {
                rs = "/admin/dashboard";
                break;
            }
        }
            if (rs == null) throw new IllegalStateException();
            new DefaultRedirectStrategy().sendRedirect(request,response,rs);
        }

}
