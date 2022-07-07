package javafsmongolfiere.javafsmongolfiere.controller;

import javafsmongolfiere.javafsmongolfiere.models.dto.MongolfiereDTO;
import javafsmongolfiere.javafsmongolfiere.models.form.MongolfiereForm;
import javafsmongolfiere.javafsmongolfiere.models.form.MongolfiereUpdateForm;
import javafsmongolfiere.javafsmongolfiere.service.MongolfiereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mongolfiere")
public class MongolfiereController {

    private final MongolfiereService mongolfiereService;

    public MongolfiereController(MongolfiereService mongolfiereService) {
        this.mongolfiereService = mongolfiereService;
    }

    @GetMapping("/all")
    public String displayAll(Model model){
        List<MongolfiereDTO> mongolfieres = mongolfiereService.getAll();
        model.addAttribute("mongolfieres", mongolfieres);
        return "mongolfiere/displayAll";
    }

    @GetMapping("/{id:[0-9]+}/details")
    public String displayOne( @PathVariable long id, Model model){
        model.addAttribute("mongolfiere", mongolfiereService.getOne(id));
        return "mongolfiere/displayOne";
    }

    @GetMapping("/{id}/update")
    public String updateForm(@PathVariable @ModelAttribute long id, @ModelAttribute("mongolfiere") MongolfiereUpdateForm form){
        MongolfiereDTO dto = mongolfiereService.getOne(id);

        form.setNom(dto.getNom());
        form.setNbPlaces(dto.getNbPlaces());
        form.setDisponibilite(dto.isDisponibilite());

        return "mongolfiere/update";
    }

    @PostMapping("/{id}/update")
    public String processUpdate(@PathVariable long id, @ModelAttribute("mongolfiere") MongolfiereUpdateForm form){
        mongolfiereService.update(id, form);
        return "redirect:/mongolfiere/"+id+"/details";
    }


}
