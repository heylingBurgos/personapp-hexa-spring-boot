package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.terminal.model.ProfesionModelCli;

@Mapper
public class ProfesionMapperCli {
    public ProfesionModelCli fromDomainToAdapterCli(Profession profession) {
        ProfesionModelCli profesionModelCli = new ProfesionModelCli();
        profesionModelCli.setDes(profession.getDescription());
        profesionModelCli.setNom(profession.getName());
        profesionModelCli.setId(profession.getIdentification());
        return profesionModelCli;
    }

    public Profession fromAdapterCliToDomain(ProfesionModelCli profesionModelCli) {
        Profession profession = new Profession();
        profession.setIdentification(profesionModelCli.getId());
        profession.setName(profesionModelCli.getNom());
        profession.setDescription(profesionModelCli.getDes());
        return profession;
    }
}
