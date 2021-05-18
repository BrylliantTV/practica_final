package bryan.travelAPP.restController;

import bryan.travelAPP.domain.Airline;
import bryan.travelAPP.domain.Airport;
import bryan.travelAPP.repository.AirlineRepository;
import bryan.travelAPP.restController.exception.AirlineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class AirlineRestController {

    private final AirlineRepository airlineRepository;

    @Autowired
    private EntityManager em;

    public AirlineRestController(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }


    @GetMapping("/airline/airlines")
    public List<Airline> getAll() {
        List<Airline> airlines = (List<Airline>) airlineRepository.findAll();
        if (airlines.isEmpty()) {
            throw new AirlineNotFoundException("No hay aerolineas");
        }
        return airlines;
    }

    @PostMapping("/airline/createAirline")
    public Airline newAirline(@RequestBody Airline newAirline) {
        Airline airline = airlineRepository.save(newAirline);
        return airlineRepository.save(newAirline);
    }
}
