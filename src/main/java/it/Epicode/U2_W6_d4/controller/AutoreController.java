package it.Epicode.U2_W6_d4.controller;



import it.Epicode.U2_W6_d4.dto.AutoreDto;
import it.Epicode.U2_W6_d4.exception.NonTrovatoException;
import it.Epicode.U2_W6_d4.model.Autore;
import it.Epicode.U2_W6_d4.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore saveAutore(@RequestBody AutoreDto autoreDto){

        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("/autori")
    public Page<Autore> getAutori(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy){

        return autoreService.getAutori(page, size, sortBy);
    }

    @GetMapping("/autori/{id}")
    public Autore getAutore(@PathVariable int id) throws NonTrovatoException {
        return autoreService.getAutore(id);
    }
    @PutMapping("/autori/{id}")
    public Autore updateAutore(@PathVariable int id,@RequestBody AutoreDto autoreDto) throws NonTrovatoException {
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/autori/{id}")
    public void deleteAutore(@PathVariable int id) throws NonTrovatoException {
        autoreService.deleteAutore(id);
    }
}
