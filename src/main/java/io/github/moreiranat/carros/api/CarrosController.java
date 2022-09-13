package io.github.moreiranat.carros.api;

import io.github.moreiranat.carros.domain.Carro;
import io.github.moreiranat.carros.domain.CarroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {

    private CarroService carroService = new CarroService();

    @GetMapping
    public List<Carro> get() {

        return carroService.getCarros();
    }

}
