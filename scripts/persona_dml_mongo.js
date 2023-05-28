use persona_db

db.persona.insertMany([
	{
		"_id": NumberInt(123456789),
		"nombre": "Pepe",
		"apellido": "Perez",
		"genero": "M",
		"edad": NumberInt(30),
		"_class": "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
	},
	{
		"_id": NumberInt(987654321),
		"nombre": "Milena",
		"apellido": "Perez",
		"genero": "M",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
	},
	{
		"_id": NumberInt(321654987),
		"nombre": "Pepa",
		"apellido": "Juarez",
		"genero": "F",
		"edad": NumberInt(30),
		"_class": "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
	},
	{
		"_id": NumberInt(147258369),
		"nombre": "Pepita",
		"apellido": "Juarez",
		"genero": "F",
		"edad": NumberInt(10),
		"_class": "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
	},
	{
		"_id": NumberInt(963852741),
		"nombre": "Fede",
		"apellido": "Perez",
		"genero": "M",
		"edad": NumberInt(18),
		"_class": "co.edu.javeriana.as.personapp.mongo.document.PersonaDocument"
	}
], { ordered: false })

//Profesiones
db.profesiones.insertMany([
	{
		"_id": 1,
		"nom": "Ingeniería industrial",
		"des": "Muy buena carrera.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	},
	{
		"_id": 2,
		"nom": "Medicina",
		"des": "Salvar vidas.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	},
	{
		"_id": 3,
		"nom": "Comunicación social",
		"des": "Nunca dar noticias falsas.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	},
	{
		"_id": 4,
		"nom": "Arte",
		"des": "Para explorar la creatividad.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	},
	{
		"_id": 5,
		"nom": "Veterinaria",
		"des": "Salvar las vidas de los animales es muy importante.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	}
], { ordered: false })

db.profesion.insertMany([
	{
		"_id": 1,
		"nom": "Ingeniería industrial",
		"des": "Muy buena carrera.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	},
	{
		"_id": 2,
		"nom": "Medicina",
		"des": "Salvar vidas.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	},
	{
		"_id": 3,
		"nom": "Comunicación social",
		"des": "Nunca dar noticias falsas.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	},
	{
		"_id": 4,
		"nom": "Arte",
		"des": "Para explorar la creatividad.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	},
	{
		"_id": 5,
		"nom": "Veterinaria",
		"des": "Salvar las vidas de los animales es muy importante.",
		"_class": "co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument"
	}
], { ordered: false })



