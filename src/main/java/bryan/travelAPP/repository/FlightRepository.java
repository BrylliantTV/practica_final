package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Integer> {
    List<Flight> findAll(Sort sort);
    //Flight findFlightCheapestPrice (Flight flight)
}
