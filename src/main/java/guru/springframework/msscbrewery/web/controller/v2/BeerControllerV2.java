package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.BeerDTO;
import guru.springframework.msscbrewery.web.model.v2.BeerDTOV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    private final BeerServiceV2 beerService;
    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable UUID id){
        return new ResponseEntity<>(beerService.getBeerById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<BeerDTOV2> saveNewBeer(@RequestBody BeerDTOV2 beerDTO){
        BeerDTOV2 beer = beerService.saveNewBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+beer.getId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BeerDTOV2> updateBeer(@PathVariable UUID id, @RequestBody BeerDTOV2 beerDTO){
        return new ResponseEntity<>(beerService.updateBeer(beerDTO),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BeerDTOV2> deleteBeer(@PathVariable UUID id){
        beerService.deleteBeer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
