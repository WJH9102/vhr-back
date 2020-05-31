package cn.junhaox.vhrBack.config;

import cn.junhaox.vhrBack.model.Hr;
import cn.junhaox.vhrBack.model.RespBeen;
import cn.junhaox.vhrBack.service.HrService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.security.auth.login.CredentialExpiredException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/5/30 21:56
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .successHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();

                    Hr hr = (Hr) authentication.getPrincipal();
                    hr.setPassword(null);
                    RespBeen ok = RespBeen.ok("登陆成功!", hr);

                    String s = new ObjectMapper().writeValueAsString(ok);
                    out.write(s);

                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    RespBeen error = RespBeen.error("登陆失败!");
                    if (e instanceof LockedException) {
                        error.setMsg("账号被锁定，请联系管理员!");
                    } else if (e instanceof CredentialsExpiredException) {
                        error.setMsg("密码过期，请联系管理员!");
                    } else if (e instanceof AccountExpiredException) {
                        error.setMsg("密码过期，请联系管理员!");
                    } else if (e instanceof DisabledException) {
                        error.setMsg("账号被禁用，请联系管理员!");
                    } else if (e instanceof BadCredentialsException) {
                        error.setMsg("用户名密码输入错误，请重新输入!");
                    } else {
                        error.setMsg("未知错误!");
                    }
                    out.write(new ObjectMapper().writeValueAsString(error));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();

                    RespBeen ok = RespBeen.ok("注销成功!");

                    String s = new ObjectMapper().writeValueAsString(ok);
                    out.write(s);

                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .csrf().disable();
    }
}
