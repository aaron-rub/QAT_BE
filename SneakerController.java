import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@RestController
public class SneakerController {
    private List<Sneaker> sneakers;

    public SneakerController() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            sneakers = mapper.readValue(Paths.get("sneakers.json").toFile(), new TypeReference<List<Sneaker>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            sneakers = new ArrayList<>();
        }
    }

    @GetMapping("/sneakers")
    public List<Sneaker> getSneakers(@RequestParam(required = false) String sort) {
        if ("price".equals(sort)) {
            sneakers.sort(Comparator.comparingInt(Sneaker::getRetail_price_cents));
        } else if ("name".equals(sort)) {
            sneakers.sort(Comparator.comparing(Sneaker::getName));
        }
        return sneakers;
    }
}
