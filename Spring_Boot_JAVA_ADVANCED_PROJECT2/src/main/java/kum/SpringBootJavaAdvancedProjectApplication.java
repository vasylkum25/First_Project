package kum;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kum.entity.Role;
import kum.entity.User;
import kum.repository.UserRepository;

@SpringBootApplication
@ImportAutoConfiguration(classes=WebMvcAutoConfiguration.class)
public class SpringBootJavaAdvancedProjectApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootJavaAdvancedProjectApplication.class, args);
		UserRepository userRepository = run.getBean(UserRepository.class);
		PasswordEncoder passEncod = new BCryptPasswordEncoder();
		User user = new User();
		if(userRepository.findByEmail("admin")==null){
			user.setEmail("admin");
			user.setPassword(passEncod.encode("5100117"));
			user.setRole(Role.ROLE_ADMIN);
			userRepository.save(user);
		}
	} 
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setOneIndexedParameters(true);
		argumentResolvers.add(resolver);
		super.addArgumentResolvers(argumentResolvers);
	}
}
