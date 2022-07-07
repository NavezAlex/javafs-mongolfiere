package javafsmongolfiere.javafsmongolfiere.utils;

import javafsmongolfiere.javafsmongolfiere.models.dto.MongolfiereDTO;
import javafsmongolfiere.javafsmongolfiere.models.entity.Admin;
import javafsmongolfiere.javafsmongolfiere.models.entity.Client;
import javafsmongolfiere.javafsmongolfiere.models.entity.Mongolfiere;
import javafsmongolfiere.javafsmongolfiere.repository.AdminRepository;
import javafsmongolfiere.javafsmongolfiere.repository.ClientRepository;
import javafsmongolfiere.javafsmongolfiere.repository.MongolfiereRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DataInit implements InitializingBean {

    private final AdminRepository adminRepository;
    private final MongolfiereRepository mongolfiereRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInit(AdminRepository adminRepository, MongolfiereRepository mongolfiereRepository, ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.mongolfiereRepository = mongolfiereRepository;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        List<Mongolfiere> toInsert = List.of(
                new Mongolfiere("Numéro 1", 2, true),
                new Mongolfiere("Numéro 2", 5, true),
                new Mongolfiere("Numéro 3", 2, false)
        );
        mongolfiereRepository.saveAll(toInsert);

        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRef( UUID.randomUUID() );
        adminRepository.save(admin);

    }
}
