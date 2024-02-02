package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID id){
        return new ResponseEntity<>(beerService.getBeerById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<BeerDTO> saveNewBeer(@Valid @RequestBody BeerDTO beerDTO){
        BeerDTO beer = beerService.saveNewBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+beer.getId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BeerDTO> updateBeer(@PathVariable UUID id, @RequestBody BeerDTO beerDTO){
        return new ResponseEntity<>(beerService.updateBeer(beerDTO),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BeerDTO> deleteBeer(@PathVariable UUID id){
        beerService.deleteBeer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ArrayList<String>> handleValidationErrors(MethodArgumentNotValidException ex){
        ArrayList<String> errors = new ArrayList<>(ex.getBindingResult().getErrorCount());
        ex.getBindingResult().getFieldErrors().forEach((e->{
            errors.add(e.getField() +":" + e.getDefaultMessage());
        }));
        return new ResponseEntity<ArrayList<String>>(errors, HttpStatus.BAD_REQUEST);
    }
}
