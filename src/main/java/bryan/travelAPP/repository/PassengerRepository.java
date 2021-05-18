package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
}
