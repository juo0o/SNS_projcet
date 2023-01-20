package ju.study.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
				.authorizeHttpRequests()
				.antMatchers("/board/boardList"
						, "/member/join"
						).permitAll() //인증없이 갈수잇음
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated() //인증된사람만 갈수있음
			.and()
				.formLogin()
				//.loginPage("/board/boardList")
				.loginProcessingUrl("/member/login") //실제 로그인을 진행할 요청 정보
				.defaultSuccessUrl("/board/boardList")
				.failureUrl("/member/loginResult")
				.usernameParameter("memId")
				.passwordParameter("memPw")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/member/accessDenied")
			.and()
				.logout()
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/board/boardList")
			.and()
				;

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//securty로 접근 권한을 설정하면 .js , .css 등 정적인 리소스에도 접근 권한을 확인함
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    	return (web) -> web.ignoring().antMatchers("/js/**",  "/css/**", "/images/**");
    }

}
