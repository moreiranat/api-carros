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
        Carro c = carroService.save(carro);

        return "Carro salvo com sucesso: " + c.getId();

    }

}
