package demo.web;

import demo.Person;
import demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(final Model model) {
		final List<Person> persons = this.personService.findAll();
		model.addAttribute("persons", persons);
		return "persons/list";
	}

	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public String detail(final Model model, final @PathVariable("id") Long id) {
		final Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "persons/detail";
	}


}
