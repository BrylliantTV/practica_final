package bryan.travelAPP.restController;

import bryan.travelAPP.domain.Airport;
import bryan.travelAPP.repository.AirportRepository;
import bryan.travelAPP.restController.exception.AirportNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class AiportRestController {

    private final AirportRepository airportRepository;

    @Autowired
    private EntityManager em;

    //Inyección de dependecia del servicio
    public AiportRestController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @GetMapping("/airport/aiports")
    public List<Airport> getAll() {
        List<Airport> airports = (List<Airport>) airportRepository.findAll();
        if (airports.isEmpty()) {
            throw new AirportNotFoundException("No hay ningún aeropuerto");
        }
        return airports;
    }

    @PostMapping("/aiport/createAirport")
    public Airport newAirport(@RequestBody Airport newAirport) {
        Airport airport = airportRepository.save(newAirport);
        return airportRepository.save(newAirport);
    }
}
