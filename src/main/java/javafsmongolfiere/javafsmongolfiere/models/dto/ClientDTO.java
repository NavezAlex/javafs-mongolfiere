package javafsmongolfiere.javafsmongolfiere.models.dto;

import javafsmongolfiere.javafsmongolfiere.models.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClientDTO {

    private long id;
    private String username;
    private String email;
    private LocalDate dateNaissance;

    public static ClientDTO of(Client entity) {
        if (entity == null)
            return null;

        return ClientDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .dateNaissance(entity.getDateNaissance())
                .build();
    }

}