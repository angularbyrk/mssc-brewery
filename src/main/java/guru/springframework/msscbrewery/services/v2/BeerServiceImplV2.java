package guru.springframework.msscbrewery.services.v2;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDTO;
import guru.springframework.msscbrewery.web.model.v2.BeerDTOV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeerById(UUID id) {
        return BeerDTOV2.builder()
                .id(UUID.randomUUID())
                .beerName("corona")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTO) {
        return BeerDTOV2.builder()
                .id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDTOV2 updateBeer(BeerDTOV2 beerDTO) {
        return BeerDTOV2.builder()
                .id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .beerStyle(BeerStyleEnum.LAGER)
                .build();
    }

    @Override
    public void deleteBeer(UUID id) {
        // delete
    }
}
