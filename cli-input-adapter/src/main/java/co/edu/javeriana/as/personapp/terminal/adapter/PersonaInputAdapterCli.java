package co.edu.javeriana.as.personapp.terminal.adapter;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.javeriana.as.personapp.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.edu.javeriana.as.personapp.application.port.in.PersonInputPort;
import co.edu.javeriana.as.personapp.application.port.out.PersonOutputPort;
import co.edu.javeriana.as.personapp.application.usecase.PersonUseCase;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.common.exceptions.InvalidOptionException;
import co.edu.javeriana.as.personapp.common.setup.DatabaseOption;
import co.edu.javeriana.as.personapp.terminal.mapper.PersonaMapperCli;
import co.edu.javeriana.as.personapp.terminal.model.PersonaModelCli;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Adapter
public class PersonaInputAdapterCli {

	@Autowired
	@Qualifier("personOutputAdapterMaria")
	private PersonOutputPort personOutputPortMaria;

	@Autowired
	@Qualifier("personOutputAdapterMongo")
	private PersonOutputPort personOutputPortMongo;

	@Autowired
	private PersonaMapperCli personaMapperCli;

	PersonInputPort personInputPort;

	public void setPersonOutputPortInjection(String dbOption) throws InvalidOptionException {
		if (dbOption.equalsIgnoreCase(DatabaseOption.MARIA.toString())) {
			personInputPort = new PersonUseCase(personOutputPortMaria);
		} else if (dbOption.equalsIgnoreCase(DatabaseOption.MONGO.toString())) {
			personInputPort = new PersonUseCase(personOutputPortMongo);
		} else {
			throw new InvalidOptionException("Invalid database option: " + dbOption);
		}
	}

	public void historial1() {
		log.info("Into historial PersonaEntity in Input Adapter");
		List<PersonaModelCli> persona = personInputPort.findAll().stream().map(personaMapperCli::fromDomainToAdapterCli)
					.collect(Collectors.toList());
		persona.forEach(p -> System.out.println(p.toString()));
	}
	public void historial() {
	    log.info("Into historial PersonaEntity in Input Adapter");
	    personInputPort.findAll().stream()
	        .map(personaMapperCli::fromDomainToAdapterCli)
	        .forEach(System.out::println);
	}
	public void findOne(int identification) {
		log.info("Into findOne PersonaEntity in Input Adapter");
		try {
			Person person = personInputPort.findOne(identification);
			PersonaModelCli personaModelCli = personaMapperCli.fromDomainToAdapterCli(person);
			System.out.println("Person found:\n" + personaModelCli.toString());
		} catch (Exception e) {
			log.warn(e.getMessage());
			System.out.println("Error.");
		}
	}

	public void createPerson(PersonaModelCli personaModelCli) {
		log.info("Into createPerson PersonaEntity in Input Adapter");
		try {
			personInputPort.create(personaMapperCli.fromAdapterCliToDomain(personaModelCli));
			System.out.println("Person created.");
		} catch (Exception e) {
			log.warn(e.getMessage());
			System.out.println("Error.");
		}
	}

	public void deletePerson(int identification) {
		log.info("Into deletePerson PersonaEntity in Input Adapter");
		try {
			if (personInputPort.drop(identification)){
				System.out.println("Person deleted.");
			}else{
				System.out.println("Error at delete.");
			}
		} catch (Exception e) {
			log.warn(e.getMessage());
			System.out.println("Error.");
		}
	}

	public void editPerson(PersonaModelCli personaModelCli) {
		log.info("Into editPerson PersonaEntity in Input Adapter");
		try {
			personInputPort.edit(personaModelCli.getCc(),personaMapperCli.fromAdapterCliToDomain(personaModelCli));
			System.out.println("Person edited.");
		} catch (Exception e) {
			log.warn(e.getMessage());
			System.out.println("Error.");
		}
	}
}
