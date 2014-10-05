package demo;

import demo.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = {ControllerTestConfig.class})
public class PersonControllerTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private PersonService personService;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testList() throws Exception {
		when(personService.findAll()).thenReturn(Arrays.asList(new Person()));

		final ResultActions perform = mockMvc.perform(get("/persons/"));

		perform
				.andExpect(status().isOk())
				.andExpect(view().name("persons/list"))
				.andExpect(model().attribute("persons", hasSize(1)))
		;
	}

	@Test
	public void testDetail() throws Exception {
		final Long personId = 1L;
		when(personService.findPerson(personId)).thenReturn(new Person());
		final ResultActions perform = mockMvc.perform(get("/persons/{personId}/", personId));

		perform
				.andExpect(status().isOk())
				.andExpect(view().name("persons/detail"))
				.andExpect(model().attribute("person", notNullValue()))
		;
	}
}