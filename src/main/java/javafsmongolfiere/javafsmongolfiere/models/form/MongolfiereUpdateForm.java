package javafsmongolfiere.javafsmongolfiere.models.form;

import lombok.Data;

@Data
public class MongolfiereUpdateForm {

    private String nom;
    private int nbPlaces;
    private boolean disponibilite;
}
