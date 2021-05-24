package cz.czechitas.java2webapps.ukol7;

import cz.czechitas.java2webapps.ukol7.entity.Vizitka;
import cz.czechitas.java2webapps.ukol7.repository.VizitkyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class VizitkyKontroler {
    private final VizitkyRepository repository;

    @Autowired
    public VizitkyKontroler(VizitkyRepository repository) {
        this.repository = repository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public Object seznam() {
        Iterable<Vizitka> seznamVizitek = repository.findAll();
        return new ModelAndView("seznam")
                .addObject("vizitky", seznamVizitek);
    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable Integer id) {
        Optional<Vizitka> vizitka = repository.findById(id);
        if (vizitka.isPresent()) {
            return new ModelAndView("vizitka")
                    .addObject("vizitka", vizitka.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/novy")
    public Object novy() {
        return new ModelAndView("formular")
                .addObject("vizitka", new Vizitka());
    }

    @PostMapping("/novy")
    public Object pridat(@ModelAttribute("osoba") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        repository.save(vizitka);
        return "redirect:/";
    }

    @PostMapping("/{id:[0-9]+}")
    public Object ulozit(@PathVariable long id, @ModelAttribute("osoba") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        repository.save(vizitka);
        return "redirect:/";
    }
}
