package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID id);
    BeerDTO saveNewBeer(BeerDTO beerDTO);
    BeerDTO updateBeer(BeerDTO beerDTO);
    void deleteBeer(UUID id);
}
