package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
}
