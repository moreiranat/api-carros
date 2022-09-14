package io.github.moreiranat.carros.api;

import io.github.moreiranat.carros.domain.Carro;
import io.github.moreiranat.carros.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public Iterable<Carro> get() {
        return carroService.getCarros();
    }

    @GetMapping("/{id}")
    public Optional<Carro> get(@PathVariable("id") Long id) {
        return carroService.getCarroById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> get(@PathVariable("tipo") String tipo) {
        return carroService.getCarroByTipo(tipo);
    }

    @PostMapping
    public String post(@RequestBody Carro carro) {
        Carro c = carroService.insert(carro);

        return "Carro salvo com sucesso: " + c.getId();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Carro carro) {
        Carro c = carroService.update(carro, id);

        return "Carro atualizado com sucesso: " + c.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        carroService.delete(id);

        return "Carro deletado com sucesso";
    }

}
