package Fusion.Internship.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/", "/Home", "/register","/register/database", "/login", "/login/database", "/logout", "/table", "/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}
