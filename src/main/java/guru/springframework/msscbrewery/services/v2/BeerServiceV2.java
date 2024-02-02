package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDTOV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDTOV2 getBeerById(UUID id);

    BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTO);

    BeerDTOV2 updateBeer(BeerDTOV2 beerDTO);

    void deleteBeer(UUID id);
}
