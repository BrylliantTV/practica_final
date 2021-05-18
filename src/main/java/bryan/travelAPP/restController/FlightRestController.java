package bryan.travelAPP.restController;

import bryan.travelAPP.domain.Flight;
import bryan.travelAPP.repository.FlightRepository;
import bryan.travelAPP.restController.exception.FlightNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightRestController {

    private final FlightRepository flightRepository;

    public FlightRestController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/flight/flights")
    public List<Flight> getAll() {
        List<Flight> flights = (List<Flight>) flightRepository.findAll();
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("No hay vuelos");
        }
        return flights;
    }
}
