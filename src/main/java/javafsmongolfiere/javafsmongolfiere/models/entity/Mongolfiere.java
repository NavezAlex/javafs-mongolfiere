package javafsmongolfiere.javafsmongolfiere.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Mongolfiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private int nbPlaces;
    private boolean disponibilite;

    public Mongolfiere() {
    }

    public Mongolfiere(String nom, int nbPlaces, boolean disponibilite){
        this.nom = nom;
        this.nbPlaces = nbPlaces;
        this.disponibilite = disponibilite;
    }

}
