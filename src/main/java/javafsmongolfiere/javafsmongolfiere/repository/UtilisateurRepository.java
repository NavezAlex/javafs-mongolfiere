package javafsmongolfiere.javafsmongolfiere.repository;

import javafsmongolfiere.javafsmongolfiere.models.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByUsername(String username);
}
