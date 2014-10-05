package demo.service;

import demo.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {

	public Person findPerson(final Long id) {
		return createPerson("stefan", "meyer");
	}

	public List<Person> findAll() {
		return Arrays.asList(createPerson("stefan", "meyer"), createPerson("Stefanie", "Meyer"));
	}

	private Person createPerson(final String name, final String surname) {
		final Person person = new Person();
		person.setName(name);
		person.setSurname(surname);
		return person;
	}
}
