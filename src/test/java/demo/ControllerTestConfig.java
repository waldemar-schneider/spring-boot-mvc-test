package demo;

import demo.service.PersonService;
import demo.web.PersonController;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@WebAppConfiguration
@Import(value = {GroovyTemplateAutoConfiguration.GroovyMarkupConfiguration.class,
		GroovyTemplateAutoConfiguration.GroovyWebConfiguration.class})
public class ControllerTestConfig {

	@Bean
	public PersonController personController() {
		return new PersonController();
	}

	@Bean
	public PersonService personService() {
		return Mockito.mock(PersonService.class);
	}

	@Bean
	public GroovyTemplateProperties groovyTemplateProperties() {
		return new GroovyTemplateProperties();
	}
}
