package cn.eastnight.common.security;

import cn.eastnight.common.util.WnPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>标题：Security 配置类</p>
 * <p>功能：</p>
 * <p>作者：屈晓东</p>
 * <p>类名称：SecurityConfig</p>
 * <p>创建日期：2021/7/7 15:37</p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("EastNight-UserService")
    private UserDetailsService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/*", "/index", "/sendMessage", "/getAllUser").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login_page")
                .loginProcessingUrl("/login/form")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureForwardUrl("/error")
                .successForwardUrl("/index")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        //开启跨域访问
        http.cors().disable();
        //开启模拟请求，比如API POST测试工具的测试，不开启时，API POST为报403错误
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        //静态资源忽略
        web.ignoring().mvcMatchers("/css/**", "/data/**", "/images/**", "/js/**", "/lib/**", "/template/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        // 使用自定义登录身份认证组件
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new WnPasswordEncoder();
    }

}
