package co.edu.javeriana.as.personapp.controller;

import co.edu.javeriana.as.personapp.adapter.TelefonoInputAdapterRest;
import co.edu.javeriana.as.personapp.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.model.response.TelefonoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/telefono")
public class TelefonoControllerV1 {
    @Autowired
    private TelefonoInputAdapterRest telefonoInputAdapterRest;

    @ResponseBody
    @GetMapping(path="/{database}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TelefonoResponse> telefonos(@PathVariable String database){
        log.info("Into telefonos REST API");
        return telefonoInputAdapterRest.historial(database.toUpperCase());
    }

    @ResponseBody
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TelefonoResponse crearTelefono(@RequestBody TelefonoRequest request) {
        log.info("esta en el metodo crearTelefono en el controller del api");
        return telefonoInputAdapterRest.createPhone(request);
    }

    @ResponseBody
    @GetMapping(path = "/{database}/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TelefonoResponse findPhoneById(@PathVariable String database, @PathVariable String num){
        log.info("Into telefonoById REST API");
        return telefonoInputAdapterRest.findOne(database, num);
    }

    @ResponseBody
    @DeleteMapping(path = "/{database}/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TelefonoResponse deletePhone(@PathVariable String database, @PathVariable String num) {
        log.info("Into deleteTelefonoById REST API");
        return telefonoInputAdapterRest.deletePhone(database, num);
    }

    @ResponseBody
    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TelefonoResponse updatePhone(@RequestBody TelefonoRequest request) {
        log.info("Into updateTelefonoById REST API");
        return telefonoInputAdapterRest.editPhone(request);
    }
}
