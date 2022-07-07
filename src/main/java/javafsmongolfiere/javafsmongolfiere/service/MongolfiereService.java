package javafsmongolfiere.javafsmongolfiere.service;

import javafsmongolfiere.javafsmongolfiere.models.dto.MongolfiereDTO;
import javafsmongolfiere.javafsmongolfiere.models.form.MongolfiereUpdateForm;

import java.util.List;

public interface MongolfiereService {

    List<MongolfiereDTO> getAll();
    MongolfiereDTO getOne(long id);

    void update(long id, MongolfiereUpdateForm form);
}
