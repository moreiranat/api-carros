package io.github.moreiranat.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Iterable<Carro> getCarros() {
        return carroRepository.findAll();
    }

    public Optional<Carro> getCarroById(Long id) {
        return carroRepository.findById(id);
    }

    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "Brasília"));
        carros.add(new Carro(3L, "Chevette"));

        return carros;
    }

}
