package co.edu.javeriana.as.personapp.terminal.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.javeriana.as.personapp.common.exceptions.InvalidOptionException;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.terminal.adapter.PersonaInputAdapterCli;
import co.edu.javeriana.as.personapp.terminal.model.PersonaModelCli;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonaMenu {

	private static final int OPCION_REGRESAR_MODULOS = 0;
	private static final int PERSISTENCIA_MARIADB = 1;
	private static final int PERSISTENCIA_MONGODB = 2;
	private static final int OPCION_REGRESAR_MOTOR_PERSISTENCIA = 0;
	private static final int OPCION_VER_TODO = 1;
	private static final int OPCION_BUSCAR_PERSONA = 2;
	private static final int OPCION_CREAR_PERSONA = 3;
	private static final int OPCION_ELIMINAR_PERSONA = 4;
	private static final int OPCION_EDITAR_PERSONA = 5;

	public void iniciarMenu(PersonaInputAdapterCli personaInputAdapterCli, Scanner keyboard) {
		boolean isValid = false;
		do {
			try {
				mostrarMenuMotorPersistencia();
				int opcion = leerOpcion(keyboard);
				switch (opcion) {
				case OPCION_REGRESAR_MODULOS:
					isValid = true;
					break;
				case PERSISTENCIA_MARIADB:
					personaInputAdapterCli.setPersonOutputPortInjection("MARIA");
					menuOpciones(personaInputAdapterCli,keyboard);
					break;
				case PERSISTENCIA_MONGODB:
					personaInputAdapterCli.setPersonOutputPortInjection("MONGO");
					menuOpciones(personaInputAdapterCli,keyboard);
					break;
				default:
					log.warn("La opción elegida no es válida.");
				}
			}  catch (InvalidOptionException e) {
				log.warn(e.getMessage());
			}
		} while (!isValid);
	}

	private void menuOpciones(PersonaInputAdapterCli personaInputAdapterCli, Scanner keyboard) {
		boolean isValid = false;
		do {
			try {
				mostrarMenuOpciones();
				int opcion = leerOpcion(keyboard);
				switch (opcion) {
				case OPCION_REGRESAR_MOTOR_PERSISTENCIA:
					isValid = true;
					break;
				case OPCION_VER_TODO:
					personaInputAdapterCli.historial();					
					break;
				case OPCION_BUSCAR_PERSONA:
					personaInputAdapterCli.findOne(findPerson(keyboard));
					break;
				case OPCION_CREAR_PERSONA:
					personaInputAdapterCli.createPerson(createEntity(keyboard));
					break;
				case OPCION_ELIMINAR_PERSONA:
					personaInputAdapterCli.deletePerson(findPerson(keyboard));
					break;
				case OPCION_EDITAR_PERSONA:
					personaInputAdapterCli.editPerson(editPerson(keyboard));
					break;
				default:
					log.warn("La opción elegida no es válida.");
				}
			} catch (InputMismatchException e) {
				log.warn("Solo se permiten números.");
			}
		} while (!isValid);
	}

	private void mostrarMenuOpciones() {
		System.out.println("----------------------");
		System.out.println(OPCION_VER_TODO + " para ver todas las personas");
		System.out.println(OPCION_BUSCAR_PERSONA + " para buscar una persona");
		System.out.println(OPCION_CREAR_PERSONA + " para crear una persona");
		System.out.println(OPCION_ELIMINAR_PERSONA + " para eliminar una persona");
		System.out.println(OPCION_EDITAR_PERSONA + " para editar una persona");
		System.out.println(OPCION_REGRESAR_MOTOR_PERSISTENCIA + " para regresar");
	}

	private void mostrarMenuMotorPersistencia() {
		System.out.println("----------------------");
		System.out.println(PERSISTENCIA_MARIADB + " para MariaDB");
		System.out.println(PERSISTENCIA_MONGODB + " para MongoDB");
		System.out.println(OPCION_REGRESAR_MODULOS + " para regresar");
	}

	private int leerOpcion(Scanner keyboard) {
		try {
			System.out.print("Ingrese una opción: ");
			return keyboard.nextInt();
		} catch (InputMismatchException e) {
			log.warn("Solo se permiten números.");
			return leerOpcion(keyboard);
		}
	}

	private PersonaModelCli createEntity(Scanner keyboard){
		try{
			PersonaModelCli person = new PersonaModelCli();
			System.out.println("Ingrese cédula: ");
			person.setCc(keyboard.nextInt());
			return personData(keyboard, person);
		} catch (InputMismatchException e) {
			System.out.println("Datos incorrectos.");
			return createEntity(keyboard);
		}

	}

	private int findPerson(Scanner keyboard){
		try{
			System.out.println("Ingrese la cédula de la persona: ");
			return keyboard.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Datos incorrectos.");
			return findPerson(keyboard);
		}
	}

	private PersonaModelCli editPerson(Scanner keyboard){
		try {
			int cc = findPerson(keyboard);
			PersonaModelCli person = new PersonaModelCli();
			person.setCc(cc);
			return personData(keyboard, person);
		}catch (InputMismatchException e) {
			System.out.println("Datos incorrectos.");
			return editPerson(keyboard);
		}
	}

	private PersonaModelCli personData(Scanner keyboard, PersonaModelCli person) {
		System.out.println("Ingrese nombre: ");
		person.setNombre(keyboard.next());
		System.out.println("Ingrese apellido: ");
		person.setApellido(keyboard.next());
		System.out.println("Ingrese edad: ");
		person.setEdad(keyboard.nextInt());
		System.out.println("Ingrese el género (M másculino, F femenino): ");
		person.setGenero(keyboard.next());
		return person;
	}


}
