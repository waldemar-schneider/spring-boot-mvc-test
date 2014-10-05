yieldUnescaped '<!DOCTYPE html>'

html (class: 'no-js', lang: 'en') {
    head {
    }

	body {
	h2 'Person list'
	table {
            thead {
                tr {
                    th 'Name'
                    th 'Surname'
                }
            }
            persons.each { person ->
                tr {
                    td person.name
                    td person.surname
                }
            }
        }
	}
}