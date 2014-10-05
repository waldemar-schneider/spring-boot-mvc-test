package demo;

import demo.service.PersonService;
import demo.web.PersonController;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@WebAppConfiguration
public class ControllerTestConfig {

	@Bean
	public PersonController personController() {
		return new PersonController();
	}

	@Bean
	public PersonService personService() {
		return Mockito.mock(PersonService.class);
	}
}
