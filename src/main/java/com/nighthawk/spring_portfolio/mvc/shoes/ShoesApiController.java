package com.nighthawk.spring_portfolio.mvc.shoes;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/shoes")  // all requests in file begin with this URI
public class ShoesApiController {

    // Autowired enables Control to connect URI request and POJO Object to easily for Database CRUD operations
    @Autowired
    private ShoesJpaRepository repository;

    /* GET List of Jokes
     * @GetMapping annotation is used for mapping HTTP GET requests onto specific handler methods.
     */
    @GetMapping("/")
    public ResponseEntity<List<Jokes>> getJokes() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    /* Update Like
     * @PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable annotation extracts the templated part {id}, from the URI
     */
    @Getmapping("/name")
    public ResponseEntity<Jokes> getName(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Shoes names = repository.findAll()
        int i, j;
        Shoes key;
        for (i = 1; i < n; i++) {
            key = names[i];
            j = i - 1;
    
            while (j >= 0 && names[j].name.compareTo(key.name)>0) {
                names[j + 1] = names[j];
                j = j - 1;
            }
            names[j + 1] = key;
        return names;
    }

    @GetMapping("/price")
    public ResponseEntity<Jokes> getName(@PathVariable long id) {
        Shoes price = repository.findAll()
        int i, j;
        Shoes temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (price[j].price > price[j + 1].price) {
                    temp = price[j];
                    price[j] = price[j + 1];
                    price[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
}
