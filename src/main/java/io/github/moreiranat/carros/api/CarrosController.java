package io.github.moreiranat.carros.api;

import io.github.moreiranat.carros.domain.Carro;
import io.github.moreiranat.carros.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Optional<Carro> get(@PathVariable Long id) {
        return carroService.getCarroById(id);
    }

}
