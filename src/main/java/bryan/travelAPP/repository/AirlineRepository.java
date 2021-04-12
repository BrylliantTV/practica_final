package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Airline;
import org.springframework.data.repository.CrudRepository;

public interface AirlineRepository  extends CrudRepository<Airline, Long> {
}
