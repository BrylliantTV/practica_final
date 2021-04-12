package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long> {
}
