package co.edu.javeriana.as.personapp.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import co.edu.javeriana.as.personapp.adapter.PersonaInputAdapterRest;
import co.edu.javeriana.as.personapp.model.request.PersonaRequest;
import co.edu.javeriana.as.personapp.model.response.PersonaResponse;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Slf4j
@RestController
@RequestMapping("/api/v1/persona")
public class PersonaControllerV1 {
	
	@Autowired
	private PersonaInputAdapterRest personaInputAdapterRest;

	@Operation(summary = "Obtener historial de personas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Personas obtenidas exitosamente"),
			@ApiResponse(responseCode = "404", description = "Personas no encontradas")
	})
	@ResponseBody
	@GetMapping(path = "/{database}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonaResponse> personas(
			@Parameter(description = "Nombre de la base de datos", required = true, example = "myDatabase")
			@PathVariable String database) {
		log.info("Into personas REST API");
			return personaInputAdapterRest.historial(database.toUpperCase());
	}

	@Operation(summary = "Crear una persona con sus datos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Persona creada exitosamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida")
	})
	@ResponseBody
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonaResponse crearPersona(
			@Parameter(description = "Solicitud de creación de persona", required = true)
			@RequestBody PersonaRequest request) {
		log.info("esta en el metodo crearTarea en el controller del api");
		return personaInputAdapterRest.crearPersona(request);
	}

	@Operation(summary = "Buscar persona por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Persona encontrada exitosamente"),
			@ApiResponse(responseCode = "404", description = "Persona no encontrada")
	})
	@ResponseBody
	@GetMapping(path = "/{database}/{cc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonaResponse findPersonById(
			@Parameter(description = "Nombre de la base de datos", required = true, example = "myDatabase")
			@PathVariable String database,
			@Parameter(description = "Cédula de la persona", required = true, example = "1234567890")
			@PathVariable String cc) {
		log.info("Into personaById REST API");
		return personaInputAdapterRest.findOne(database, cc);
	}

	@Operation(summary = "Eliminar persona por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Persona eliminada exitosamente"),
			@ApiResponse(responseCode = "404", description = "Persona no encontrada")
	})
	@ResponseBody
	@DeleteMapping(path = "/{database}/{cc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonaResponse deletePersonaById(
			@Parameter(description = "Nombre de la base de datos", required = true, example = "myDatabase")
			@PathVariable String database,
			@Parameter(description = "Cédula de la persona", required = true, example = "1234567890")
			@PathVariable String cc) {
		log.info("Into deletePersonaById REST API");
		return personaInputAdapterRest.deletePerson(database, cc);
	}

	@Operation(summary = "Actualizar persona por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Persona actualizada exitosamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
			@ApiResponse(responseCode = "404", description = "Persona no encontrada")
	})
	@ResponseBody
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonaResponse updatePersonaById(
			@Parameter(description = "Solicitud de actualización de persona", required = true)
			@RequestBody PersonaRequest request) {
		log.info("Into updatePersonaById REST API");
		return personaInputAdapterRest.editPerson(request);
	}


}
