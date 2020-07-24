package finalproject.config;


import finalproject.models.detailsService.MyUserDetails;
import finalproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   private final MyUserDetails myUserDetails;
   private final PasswordEncoder passwordEncoder;

   @Autowired
   public SecurityConfig(MyUserDetails myUserDetails, PasswordEncoder passwordEncoder) {
       this.myUserDetails = myUserDetails;
       this.passwordEncoder = passwordEncoder;
   }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

       auth
               .userDetailsService(myUserDetails)
               .passwordEncoder(passwordEncoder);
    }

    @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/**").permitAll()
               .antMatchers("/users/login").permitAll()
               .antMatchers("/users/register").permitAll()
               .anyRequest().authenticated()
               .and()
               .formLogin()
                .loginPage("/users/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
               .and()
               .logout()
               .logoutSuccessUrl("/");

   }
//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//       http
//               .cors()
//               .disable()
//               .csrf()
// //                  .csrfTokenRepository(this.csrfTokenRepository())
//               .disable()
// //              .and()
//               .authorizeRequests()
//               .antMatchers("/**").permitAll()
//               .anyRequest().permitAll()
//               .and()
//               .formLogin()
//               .loginPage("/users/login")
//               .usernameParameter("email")
//               .passwordParameter("password")
//               .defaultSuccessUrl("/home")
//               .and()
//               .logout()
//               .logoutUrl("/logout")
//               .logoutSuccessUrl("/")
//               .and()
// //              .rememberMe()
// //                  .rememberMeParameter("rememberMe")
// //                  .key("rmmbrm")
// //                  .userDetailsService(this.userService)
// //                  .rememberMeCookieName("RMMBRM")
// //                  .tokenValiditySeconds(1200)
// //              .and()
//               .exceptionHandling()
//               .accessDeniedPage("/error/unauthorized")
//       ;
//   }

   private CsrfTokenRepository csrfTokenRepository() {
       HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
       repository.setSessionAttributeName("_csrf");

       return repository;
   }

}
