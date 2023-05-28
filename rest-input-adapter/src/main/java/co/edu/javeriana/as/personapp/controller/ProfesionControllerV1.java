package co.edu.javeriana.as.personapp.controller;

import co.edu.javeriana.as.personapp.adapter.ProfesionInputAdapterRest;
import co.edu.javeriana.as.personapp.model.request.ProfesionRequest;
import co.edu.javeriana.as.personapp.model.response.ProfesionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/profesion")
public class ProfesionControllerV1 {
    @Autowired
    private ProfesionInputAdapterRest profesionInputAdapterRest;

    @ResponseBody
    @GetMapping(path = "/{database}", produces = "application/json")
    public List<ProfesionResponse> profesiones(@PathVariable String database) {
        log.info("Into profesiones REST API");
        return profesionInputAdapterRest.historial(database.toUpperCase());
    }

    @ResponseBody
    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    public ProfesionResponse createProfession(@RequestBody ProfesionRequest request) {
        log.info("esta en el metodo crearProfesion en el controller del api");
        return profesionInputAdapterRest.createProfession(request);
    }

    @ResponseBody
    @GetMapping(path = "/{database}/{id}", produces = "application/json")
    public ProfesionResponse findProfession(@PathVariable String database, @PathVariable String id){
        log.info("Into profesionById REST API");
        return profesionInputAdapterRest.findOneProfession(database, id);
    }

    @ResponseBody
    @DeleteMapping(path = "/{database}/{id}", produces = "application/json")
    public ProfesionResponse deleteProfession(@PathVariable String database, @PathVariable String id) {
        log.info("Into deleteProfesionById REST API");
        return profesionInputAdapterRest.deleteProfession(database, id);
    }
    @ResponseBody
    @PutMapping(path = "", produces = "application/json", consumes = "application/json")
    public ProfesionResponse updateProfession(@RequestBody ProfesionRequest request) {
        log.info("Into updateProfesionById REST API");
        return profesionInputAdapterRest.editProfession(request);
    }
}
