package javafsmongolfiere.javafsmongolfiere.service;

import javafsmongolfiere.javafsmongolfiere.mapper.MongolfiereMapper;
import javafsmongolfiere.javafsmongolfiere.models.dto.MongolfiereDTO;
import javafsmongolfiere.javafsmongolfiere.models.entity.Mongolfiere;
import javafsmongolfiere.javafsmongolfiere.models.form.MongolfiereUpdateForm;
import javafsmongolfiere.javafsmongolfiere.repository.MongolfiereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongolfiereServiceImpl implements MongolfiereService{

    private final MongolfiereRepository repository;
    private final MongolfiereMapper mapper;

    public MongolfiereServiceImpl(MongolfiereRepository repository, MongolfiereMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MongolfiereDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MongolfiereDTO getOne(long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow();
    }

    @Override
    public void update(long id, MongolfiereUpdateForm form) {
        Mongolfiere mongolfiere = repository.findById(id)
                .orElseThrow();

        mongolfiere.setNom(form.getNom());
        mongolfiere.setNbPlaces(form.getNbPlaces());
        mongolfiere.setDisponibilite(form.isDisponibilite());

        repository.save(mongolfiere);
    }
}
