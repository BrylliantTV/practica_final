package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Airport;
import bryan.travelAPP.domain.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AirportRepository extends CrudRepository<Airport, Integer> {
    List<Airport> findByNameContaining(String name);
    List<Airport> findByCode(String codeAirport);
}
