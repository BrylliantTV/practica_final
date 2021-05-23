package bryan.travelAPP.restController;

import bryan.travelAPP.domain.Airline;
import bryan.travelAPP.domain.Airport;
import bryan.travelAPP.repository.AirportRepository;
import bryan.travelAPP.restController.exception.AirportNotFoundException;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class AirportRestController {

    private final AirportRepository airportRepository;

    @Autowired
    private EntityManager em;

    //Inyección de dependecia del servicio
    public AirportRestController(AirportRepository airportRepository) {
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

    @PostMapping("/airport/createAirport")
    public Airport newAirport(@RequestBody Airport newAirport) {
        Airport airport = airportRepository.save(newAirport);
        return airportRepository.save(newAirport);
    }

    @GetMapping("/airport/aiports/{name}")
    public List<Airport> listAirportsFlights(@PathVariable String name) {
        List<Airport> airports = airportRepository.findByNameContaining(name);
        if (airports.isEmpty()) {
            throw  new AirportNotFoundException("No se han encontrado aeropuertos con el nombre: " + name);
        }
        return airports;
    }

}
