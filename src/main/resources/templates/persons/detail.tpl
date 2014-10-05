yieldUnescaped '<!DOCTYPE html>'

html (class: 'no-js', lang: 'en') {
    head {
    }
	body {
	h2 'Person detail'

        p {
            label(for: 'name', 'Name')
            input(name: 'name', type: 'text', id: 'name', placeholder: 'Name', value: person.name)
        }

        p {
            label(for: 'surname', 'Surname')
            input(name: 'surname', type: 'text', id: 'surname', placeholder: 'Name', value: person.surname)
	    }
	}
}
