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

    @Getmapping("/insert")
    public ResponseEntity<Shoes> getName(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        List<Shoes> shoes = repository.findAll()
        int i, j;
        Shoes key;
        ArrayList<List<Shoes> > progress = new ArrayList<List<Shoes> >;
        progress.add(shoes.clone());
        for (i = 1; i < shoes.size(); i++) {
            key = shoes.get(i);
            j = i - 1;
    
            while (j >= 0 && shoes.get(j).name.compareTo(key.name)>0) {
                shoes.set(j + 1,shoes.get(j));
                j = j - 1;
            }
            shoes.set(j + 1, key);
            progress.add(shoes.clone());
        return ResponseEntity<>(progress, HttpStatus.OK);
    }

    @GetMapping("/bubble")
    public ResponseEntity<Shoes> getName(@PathVariable long id) {
        List<Shoes> shoes = repository.findAll()
        int i, j;
        Shoes temp;
        boolean swapped;
        ArrayList<List<Shoes> > progress = new ArrayList<List<Shoes> >;
        progress.add(shoes.clone());
        for (i = 0; i < shoes.size() - 1; i++) {
            swapped = false;
            for (j = 0; j < shoes.size() - i - 1; j++) {
                if (shoes.get(j).name.compareTo(temp.name)>0) {
                    temp = shoes.get(j);
                    shoes.set(j,shoes.get(j + 1));
                    shoes.set(j + 1, temp);
                    swapped = true;
                }
            }
            progress.add(shoes.clone());
            if (swapped == false)
                break;
        }
        return ResponseEntity<>(progress, HttpStatus.OK);;
    }
}
