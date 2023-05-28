package co.edu.javeriana.as.personapp.model.response;

import co.edu.javeriana.as.personapp.model.request.ProfesionRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProfesionResponse extends ProfesionRequest {

    private String status;

    public ProfesionResponse(Integer identification, String name, String description, String database, String status) {
        super(identification, name, description, database);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}