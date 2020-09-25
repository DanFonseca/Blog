package br.com.daniel.spring.blog.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity)  {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/posts/newpost/", "/posts/newpost" )
                .authenticated()
                .anyRequest()
                .permitAll()
                .and().formLogin().permitAll()
                .and().logout().logoutRequestMatcher(AntPathRequestMatcher("/logout"))
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("daniel").password("{noop}123").roles("ADMIN")
    }
}