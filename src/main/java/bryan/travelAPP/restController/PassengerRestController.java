package bryan.travelAPP.restController;

import bryan.travelAPP.domain.Airline;
import bryan.travelAPP.domain.Passenger;
import bryan.travelAPP.repository.PassengerRepository;
import bryan.travelAPP.restController.exception.PassengerNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PassengerRestController {
    private final PassengerRepository passengerRepository;

    public PassengerRestController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @GetMapping("/passenger/passengers")
    public List<Passenger> getAll() {
        List<Passenger> passengers = (List<Passenger>) passengerRepository.findAll();
        if (passengers.isEmpty()) {
            throw new PassengerNotFoundException("No hay pasajeros");
        }
        return passengers;
    }
    @PostMapping("/passenger/createpassengers")
    public Passenger newPassenger(@RequestBody Passenger newPassenger) {
        Passenger passenger = passengerRepository.save(newPassenger);
        return passengerRepository.save(newPassenger);
    }
}
