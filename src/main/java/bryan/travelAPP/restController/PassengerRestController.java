package bryan.travelAPP.restController;

import bryan.travelAPP.domain.Passenger;
import bryan.travelAPP.repository.PassengerRepository;
import bryan.travelAPP.restController.exception.PassengerNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/passenger/createpassengersList")
    public List<Passenger> newPassengerList(@RequestBody List<Passenger> passengersList) {
        return (List<Passenger>) passengerRepository.saveAll(passengersList);
    }

    //EJEMPLO PARA PROBAR http://localhost:8080/passenger/page?page=1&size=15
    @GetMapping("/passenger/page")
    public Page<Passenger> findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<Passenger> passengers = passengerRepository.findAll(PageRequest.of(page, size));
        if (passengers.getTotalPages() < page) {
            throw new PassengerNotFoundException("No hay ningún valor en la página: " + page);
        }
        return passengers;
    }
    @GetMapping("/passenger/passengerOrderList")
    public List<Passenger> sortPassengers() {
        List<Passenger> passengers = passengerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return passengers;
    }
}
