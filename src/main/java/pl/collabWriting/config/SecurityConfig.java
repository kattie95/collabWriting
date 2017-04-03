package pl.collabWriting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author kattie95
 */

@Configuration
@EnableGlobalMethodSecurity (securedEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAccounts (AuthenticationManagerBuilder authentication) throws Exception
    {
       // authentication.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        authentication.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/stories/finished").hasRole("ADMIN")
                    .antMatchers("/stories/create").hasAnyRole("ADMIN","WRITER")
                    //.antMatchers("/stories/create").hasRole("ADMIN")
                    .anyRequest().permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/login?logout")
                    .permitAll();

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        httpSecurity.addFilterBefore(filter,CsrfFilter.class);
    }
}
