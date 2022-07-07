package javafsmongolfiere.javafsmongolfiere.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MongolfiereDTO {

    private long id;
    private String nom;
    private int nbPlaces;
    private boolean disponibilite;

}
