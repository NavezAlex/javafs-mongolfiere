package javafsmongolfiere.javafsmongolfiere.service;

import javafsmongolfiere.javafsmongolfiere.models.dto.ClientDTO;
import javafsmongolfiere.javafsmongolfiere.models.entity.Client;
import javafsmongolfiere.javafsmongolfiere.models.form.ClientInsertForm;
import javafsmongolfiere.javafsmongolfiere.repository.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final PasswordEncoder encoder;

    public ClientService(ClientRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<ClientDTO> getAll(){
        return repository.findAll().stream()
                .map(ClientDTO::of)
                .toList();
    }

    public long insert(ClientInsertForm form){
        Client c = form.toEntity();
        c.setPassword( encoder.encode(c.getPassword()) );
        return repository.save(c).getId();
    }
}
