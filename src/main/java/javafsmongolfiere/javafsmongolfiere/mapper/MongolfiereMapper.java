package javafsmongolfiere.javafsmongolfiere.mapper;

import javafsmongolfiere.javafsmongolfiere.models.dto.MongolfiereDTO;
import javafsmongolfiere.javafsmongolfiere.models.entity.Mongolfiere;
import javafsmongolfiere.javafsmongolfiere.models.form.MongolfiereForm;
import org.springframework.stereotype.Service;

@Service
public class MongolfiereMapper {

    public MongolfiereDTO toDto(Mongolfiere entity){
        if(entity == null)
            return null;

        return new MongolfiereDTO(
                entity.getId(),
                entity.getNom(),
                entity.getNbPlaces(),
                entity.isDisponibilite()
        );
    }

    public Mongolfiere toEntity(MongolfiereForm form){
        if (form == null)
            return null;

        return new Mongolfiere(
                form.getNom(),
                form.getNbPlaces(),
                form.isDisponibilite()
        );
    }

}
